# Heap Pattern

這份筆記使用 Java 17 的 `PriorityQueue`，整理如何辨識 Heap 題型、選擇 min-heap 或 max-heap，以及用 invariant 檢查實作。先掌握動態極值與 Top K，再延伸到多路合併、雙堆與過期資料處理。

## 一句話定義

Heap 維護一組會持續改變的候選資料，讓我們能快速取得並移除「依指定規則最優先」的元素，而不必每次把所有資料重新排序。

Priority Queue 是依優先順序取出資料的介面；Binary Heap 是常見的實作方式。這裡的 heap 指堆積資料結構，與程式的 heap memory 無關。

## 適用情境

- 反覆取出目前最小／最大值，而且取出後會加入新值。
- 只保留目前最好的 `k` 個候選，或持續查詢第 `k` 大／小。
- 合併多個已排序來源，每次只需要知道下一個最小元素。
- 資料逐筆到達，每次新增後都要能查詢中位數。
- 處理事件或資源時，每輪都需要選出目前可用候選中優先級最高的一個。

## 不適用情境

- 只查一次最大／最小值：一次掃描即可，時間 `O(n)`、額外空間 `O(1)`。
- 需要完整排序結果，資料也不會更新：通常直接排序更簡單。
- 靜態陣列只查一次第 `k` 大：可考慮 Quickselect；隨機化版本期望 `O(n)`，最壞仍可能 `O(n²)`。
- 固定視窗的最大／最小值，元素依索引順序過期：Monotonic Deque 通常能做到總時間 `O(n)`。
- 頻繁刪除任意元素、查前驅／後繼或區間：考慮 `TreeMap` 等有序結構；若還要查任意排名，需支援排名的資料結構。
- 只有普通 FIFO 或 LIFO 順序：使用 Queue 或 Stack 即可。

## 題目辨識訊號

| 題目要求 | 要維護的狀態 | 優先考慮 |
| --- | --- | --- |
| 每輪取最小、最早、成本最低 | 所有目前有效的候選 | Min-heap |
| 每輪取最大、最重、收益最高 | 所有目前有效的候選 | Max-heap |
| 前 `k` 大或第 `k` 大 | 最大的 `k` 個，堆頂是其中最小者 | 大小受限的 min-heap |
| 前 `k` 小或第 `k` 小 | 最小的 `k` 個，堆頂是其中最大者 | 大小受限的 max-heap |
| 多個已排序來源的下一個值 | 每個來源尚未處理的第一個元素 | Min-heap 加來源位置 |
| 每次插入後查中位數 | 較小一半與較大一半 | Max-heap 加 min-heap |

最關鍵的自問句：

> 每一步是否只需要候選集合中的一個極值？取出或加入資料後，下一步是否還要重新選極值？

**Heap 的方向由「下一個要取出誰」決定。** Top K 的堆頂是淘汰對象，所以「保留最大 `k` 個」反而使用 min-heap。

## 核心思維與 Invariant

### Heap 本身保證什麼

Binary Heap 是完全二元樹。Min-heap 的每個父節點都不大於子節點，所以根是全體最小值；max-heap 則相反。這個條件不要求兄弟節點有序，也不代表底層陣列已排序。

例如下面是合法的 min-heap：

```text
        2
       / \
      5   3
     / \
    9   7

以陣列保存時可以是 [2, 5, 3, 9, 7]，並非遞增序列。
```

用零起始陣列表示時，節點 `i` 的子節點是 `2*i + 1`、`2*i + 2`；`i > 0` 時父節點是 `(i - 1) / 2`。插入後向上調整，移除根後用末尾元素補位並向下調整，每次最多走樹高 `O(log h)`，其中 `h` 是 heap 大小。

### 維護的狀態

Heap 的結構性質之外，還要定義符合題意的 invariant：

| 模型 | 每輪結束時必須成立的 invariant |
| --- | --- |
| 動態極值 | Heap 恰好包含下一輪仍可被選取的候選及其最新優先級 |
| Top K | 處理 `i` 個元素後，heap 保存其中最大的 `min(k, i)` 個，保留重複次數 |
| 多路合併 | 每個尚未耗盡的來源，在 heap 中恰有一個代表：該來源第一個未輸出的元素 |
| 雙堆中位數 | `lower` 的所有值不大於 `upper` 的所有值，且 `lower` 的大小等於 `upper` 或多一個 |

### 狀態如何更新

動態極值通常是「取出 → 處理 → 放回新候選」；Top K 是「加入 → 超過 `k` 就淘汰堆頂」；多路合併是「輸出堆頂 → 補上同來源的下一個」；雙堆則在插入後調整大小。

如果比較用的欄位改變，必須恢復 heap 的排序條件。不要直接修改仍在 heap 內的物件，再期待 `peek()` 自動反映新順序。

### 為什麼不會遺漏答案

Top K 可用歸納法理解：原本已保留最大的 `k` 個，新值加入後只有 `k + 1` 個需要比較，淘汰其中最小者即可。更早被淘汰的值不會比這些保留值更好，因此在「只新增、優先級固定」的前提下，不必再考慮。

多路合併則利用來源內部已排序的條件：任何尚未露出的元素都不小於同來源的第一個未輸出元素，因此全域下一個最小值一定在 heap 中。

**Heap 只保證有效率地選出局部極值，不會自動證明貪心選擇是全域最佳。** 若題目要求最大總收益或最小總成本，仍需另外證明選擇規則。

## 解題流程

1. 寫出暴力作法，找出每輪重複的搜尋或排序。
2. 定義候選：是一個數值，還是含有分數、索引、來源的狀態？
3. 定義取出規則與同分規則，再決定 comparator。
4. 決定 heap 要保存全部候選、最多 `k` 個，或每個來源的一個代表。
5. 寫出 invariant，以及 `poll()` 後哪些狀態應放回。
6. 定義停止條件：處理完輸入、達到操作次數、heap 耗盡，或堆頂已符合門檻。
7. 用實際最大 heap 大小計算複雜度，檢查空集合、重複值、索引與溢位。

## Java PriorityQueue 基礎

以下片段及後續模板使用這些匯入；完整類別可各自放入同名 `.java` 檔：

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
```

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

minHeap.offer(7);
minHeap.offer(2);
int smallest = minHeap.peek(); // 2，只讀取
int removed = minHeap.poll();  // 2，讀取並移除
```

`PriorityQueue` 取出的是 comparator 認為最小的元素。相等元素的先後順序沒有保證；iterator 也不保證排序。空 queue 的 `peek()`、`poll()` 回傳 `null`，直接拆箱成 `int` 會出錯。這些 API 行為可查 [Java 17 PriorityQueue 文件](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)。

| 操作 | 複雜度與條件 |
| --- | --- |
| `peek()`、`size()` | `O(1)` |
| `offer()`、`poll()` | Heap 調整為 `O(log h)`；陣列擴容成本需攤銷 |
| `contains(x)`、`remove(Object)` | `O(h)`，必須搜尋元素 |
| 逐筆 `offer` 共 `n` 個 | 上界 `O(n log n)` |
| 對已有陣列做 bottom-up heapify | `O(n)`，與逐筆插入不同 |

表中的 heap 操作假設一次比較是 `O(1)`；下文以 `log(h + 1)` 等寫法涵蓋 heap 只有零或一個元素的情況。Java 操作成本見 [PriorityQueue implementation note](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)。本筆記的建堆程式都使用逐筆 `offer`，不將其計為線性建堆。

### 自訂優先級與同分規則

例如「數值較小者優先，同值時索引較小者優先」：

```java
record Candidate(long value, int index) {}

PriorityQueue<Candidate> heap = new PriorityQueue<>(
    Comparator.comparingLong(Candidate::value)
              .thenComparingInt(Candidate::index)
);
```

用 `Integer.compare(a, b)`、`Long.compare(a, b)` 或 comparator 工具方法，避免用 `a - b` 比較造成溢位。需要 FIFO 的同分順序時，額外存遞增序號。`record` 的欄位不可變，更新時可取出舊狀態，再加入新狀態。

## 通用 Java 模板

### 模板一 保留最大的 K 個

```java
public final class TopKPattern {
    public static int kthLargest(int[] values, int k) {
        if (k < 1 || k > values.length) {
            throw new IllegalArgumentException("Require 1 <= k <= values.length");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : values) {
            heap.offer(value);          // 固定：加入候選
            if (heap.size() > k) {
                heap.poll();           // 固定：淘汰保留集合中最差者
            }
        }
        return heap.peek();            // 已有 k 個，堆頂就是第 k 大
    }
}
```

- 固定骨架：逐一加入，超過容量就移除堆頂，保持 `size <= k`。
- 可變部分：候選型別、比較的分數、同分規則、最後回傳第 `k` 個或整個保留集合。
- 第 `k` 小：改用 max-heap。資料流：把 heap 與 `k` 存成物件欄位，每次新增後執行相同裁剪；不足 `k` 個時尚無第 `k` 大。
- 複雜度：每個元素至多一次加入與移除，heap 暫時最多 `k + 1` 個，時間 `O(n log(k + 1))`、額外空間 `O(k)`。
- 若回傳所有 Top K，heap 內部沒有輸出順序保證。需要由大到小時，從 min-heap 持續 `poll()` 後反轉結果，另需 `O(k log(k + 1))` 時間。

### 模板二 反覆取出並合併極值

以下以「合併兩個最小權重，成本為兩者之和」示範固定流程。輸入權重須非負，且合併值與累積成本都能用 `long` 表示。

```java
public final class MergeCostPattern {
    public static long minimumMergeCost(long[] weights) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (long weight : weights) {
            heap.offer(weight);
        }

        long cost = 0;
        while (heap.size() >= 2) {      // 可變：停止條件
            long first = heap.poll();
            long second = heap.poll();
            long merged = first + second; // 可變：新候選的計算規則
            cost += merged;            // 可變：如何累積答案
            heap.offer(merged);        // 固定：新候選必須參與後續比較
        }
        return cost;
    }
}
```

每輪兩個候選變成一個，heap 大小減一，因此非空輸入最多執行 `n - 1` 輪。含逐筆建堆，時間 `O(n log(n + 1))`、額外空間 `O(n)`；空輸入與單一權重的成本皆為 `0`。

這個合併規則的貪心理由：把合併過程畫成二元樹，總成本等於每個原始權重乘以其深度後加總。可在最佳樹中選一對最深的兄弟葉節點，把最小兩個權重交換到那裡而不增加成本；將它們合併成一個權重後，剩下的是同型子問題。因此可以先合併最小兩者。可對照 [repo 合併成本練習](Q1167.java)。

若改成其他合併公式，這個最佳性證明不一定成立；若題目本來就指定每輪取最小兩個，則是在模擬規則，不必另外選擇貪心策略。

### 模板三 合併多個已排序來源

用陣列示範，避免綁定某一題的節點型別。所有來源須已由小到大排序，且 `sources` 與每個子陣列皆非 `null`；允許空子陣列。

```java
public final class KWayMergePattern {
    private record Cursor(int value, int source, int index) {}

    public static List<Integer> merge(int[][] sources) {
        PriorityQueue<Cursor> heap = new PriorityQueue<>(
            Comparator.comparingInt(Cursor::value)
        );
        for (int source = 0; source < sources.length; source++) {
            if (sources[source].length > 0) {
                heap.offer(new Cursor(sources[source][0], source, 0));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            Cursor current = heap.poll();
            result.add(current.value());

            int next = current.index() + 1;
            int source = current.source();
            if (next < sources[source].length) {
                heap.offer(new Cursor(sources[source][next], source, next));
            }
        }
        return result;
    }
}
```

固定骨架是「每個來源只放一個前端候選，取出後只推進該來源」。可變部分是來源的表示方式；鏈結串列改成放節點，取出後加入 `node.next`。若同值時要求來源順序，再把來源編號加入 comparator。

令 `m` 為來源數、`r` 為非空來源數、`N` 為總元素數。初始化需掃過全部 `m` 個來源，heap 最多 `r` 個，每個元素入堆及出堆一次，因此時間 `O(m + N log(r + 1))`。額外 heap 空間 `O(r)`，此模板另保存 `O(N)` 輸出；若逐筆消費輸出，可省去結果列表。

### 模板四 雙堆維護中位數

`lower` 是較小一半的 max-heap，`upper` 是較大一半的 min-heap。中位數只需讀取兩半交界。

```java
public final class RunningMedian {
    private final PriorityQueue<Integer> lower =
        new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void add(int value) {
        if (lower.isEmpty() || value <= lower.peek()) {
            lower.offer(value);
        } else {
            upper.offer(value);
        }

        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double median() {
        if (lower.isEmpty()) {
            throw new NoSuchElementException("No values yet");
        }
        if (lower.size() > upper.size()) {
            return lower.peek();
        }
        return ((long) lower.peek() + upper.peek()) / 2.0;
    }
}
```

插入時先用 `lower` 的最大值決定分側，保持兩半的大小關係；再移動邊界元素恢復數量平衡。每次只新增一個值，因此最多搬動一個邊界元素。奇數個元素取 `lower.peek()`，偶數個則取兩堆頂的平均。

這個模板固定讓 `lower` 在奇數時多一個；若改成 `upper` 多一個，中位數判斷也必須同步調整。先轉 `long` 再相加，避免 `int` 加法先溢位；除以 `2.0` 保留小數。累積 `n` 個值時，每次新增 `O(log(n + 1))`、查詢 `O(1)`、總空間 `O(n)`。

## Worked Example 保留最大的三個值

```text
values = [5, 1, 5, 2, 9, 4], k = 3
```

下表把保留值排序呈現，方便閱讀；它不是 heap 的實際陣列或 iterator 順序。

| 新值 | 加入後淘汰誰 | 本輪結束時保留值 | 第三大 |
| --- | --- | --- | --- |
| `5` | 無 | `[5]` | 尚不足三個 |
| `1` | 無 | `[1, 5]` | 尚不足三個 |
| `5` | 無 | `[1, 5, 5]` | `1` |
| `2` | `1` | `[2, 5, 5]` | `2` |
| `9` | `2` | `[5, 5, 9]` | `5` |
| `4` | `4` | `[5, 5, 9]` | `5` |

兩個 `5` 都佔排名，因此第三大是 `5`。最後的 `4` 加入後立刻被淘汰，示範「先加再裁剪」不需要額外處理新值是否更好的分支。

## 常見變形

### 先轉成分數 再做 Top K

高頻元素比較的是出現次數，最近點比較的是距離，保留集合中的「最差者」要放在堆頂。先完成頻率統計，再把不同值當候選，避免把同一個值重複當成多個答案。

若 comparator 讀取外部 frequency map，入堆後就不能任意修改該 map 的比較值。真正需要動態更新頻率時，須使用更新策略；靜態 Top K 的證明不能直接套到會變動的分數。

### 保存索引與同分規則

若更新最小值後還要還原原陣列，候選需保存 `(value, index)`。例如 [Q3264 題目](https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/) 指定同值時選最前面的元素，comparator 就必須再比較 index。

更新時先 `poll()`，再放入新值與原 index；最後依 index 寫回答案。若執行 `t` 次操作，逐筆建堆版本為 `O((n + t) log(n + 1))` 時間、`O(n)` 空間。[repo 的 Q3264](Q3264.java) 目前採每輪掃描的 `O(nt)` 作法，可用來比較小規模輸入下兩者的取捨。

### Lazy Deletion 處理過期候選

Java `PriorityQueue` 沒有直接的 decrease-key 操作。候選被取消、更新或離開視窗時，可另用 map 保存目前版本／有效狀態，heap 存不可變的 `(priority, id, version)` 快照；讀取堆頂前，反覆移除過期版本。

Invariant 要改為：「heap 可以包含過期資料，但真正採用的堆頂必須有效」。每次取得答案前都要清理，不能只清掉一個過期元素。

若總共加入 `p` 筆快照，每筆最多被移除一次，但 heap 實際大小 `H` 可能累積到 `O(p)`；heap 操作總時間上界為 `O(p log(p + 1))`、空間為 `O(p)`。不能因為只有 `k` 筆有效資料，就直接宣稱 lazy heap 的空間是 `O(k)`。固定視窗極值通常先考慮 Monotonic Deque。

### 可用候選與未來事件分開

排程題可能同時需要「目前可執行的最高優先級」與「下一個解鎖時間」。可用一個 heap 選可用工作，另一個按時間管理等待中的工作；每輪先釋放已到期工作，再選擇。

Heap 的 comparator 負責選擇順序，可執行條件與時間推進則由題目決定。只把所有工作依收益放進 max-heap，並不能保證取出的工作當下可執行。

## 代表題目

以下依學習順序排列；Q23、Q295 是延伸練習，其餘附有 repo 題解連結。每題的複雜度指本筆記討論的 heap 作法。

### 入門 Q1046 Last Stone Weight

- 辨識理由：每輪指定取最重的兩顆，結果可能重新成為候選。見 [LeetCode Q1046](https://leetcode.com/problems/last-stone-weight/description/)。
- 核心狀態或轉換：Max-heap 保存所有剩餘重量，可對照 [repo 題解](Q1046.java)。
- 最容易出錯的地方：相同重量都消失，最後可能為空；要先取出兩顆再放回差值。
- 一句話解法：重複取出最大兩個，不同時放回其差，直到不足兩顆。
- 複雜度：逐筆建堆與至多 `n - 1` 輪操作，時間 `O(n log(n + 1))`、空間 `O(n)`。

### 標準 Q215 Kth Largest Element in an Array

- 辨識理由：只要第 `k` 大，不需要完整排序。
- 核心狀態或轉換：Min-heap 保留最大的 `k` 個，堆頂是入選門檻，可對照 [repo 題解](Q215.java)。
- 最容易出錯的地方：重複值仍佔排名；第 `k` 大不等於第 `k` 個不同的值。見 [LeetCode Q215](https://leetcode.com/problems/kth-largest-element-in-an-array/)。
- 一句話解法：每次加入後若超過 `k` 就移除最小值，最後讀取堆頂。
- 複雜度：時間 `O(n log(k + 1))`、空間 `O(k)`。

### 標準變形 Q347 Top K Frequent Elements

- 辨識理由：選前 `k` 名，但排名依頻率而非數值。見 [LeetCode Q347](https://leetcode.com/problems/top-k-frequent-elements/)。
- 核心狀態或轉換：先統計頻率，再把 `u` 個不同值交給容量為 `k` 的 min-heap，可對照 [repo 題解](Q347.java)。
- 最容易出錯的地方：比較了數值大小，或忽略 frequency map 的空間。
- 一句話解法：保留頻率最高的 `k` 個不同值，淘汰頻率最低者。
- 複雜度：假設 hash 操作平均 `O(1)`，時間 `O(n + u log(k + 1))`、空間 `O(u + k)`。若要對所有 `k` 都保證優於 `O(n log n)`，可再練習依頻率分桶的 `O(n)` 作法；heap 在 `u`、`k` 都接近 `n` 時仍有 `O(n log n)` 上界。

### 變形 Q3066 Minimum Operations to Exceed Threshold Value II

- 辨識理由：反覆合併目前最小兩個，直到所有值達到門檻。
- 核心狀態或轉換：Min-heap 保存 `long`；取出 `x <= y` 後加入 `2*x + y`，可對照 [repo 題解](Q3066.java)。
- 最容易出錯的地方：中間值溢位、少於兩個仍繼續取值，或停止時只看大小而沒看門檻。
- 一句話解法：只要最小值仍低於門檻且至少有兩個元素，就合併並累計操作數。
- 複雜度：時間 `O(n log(n + 1))`、空間 `O(n)`。[LeetCode Q3066](https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/) 保證存在答案；重用到無此保證的題目時，迴圈後還要檢查是否成功。

### 綜合 Q23 Merge k Sorted Lists

- 辨識理由：[LeetCode Q23](https://leetcode.com/problems/merge-k-sorted-lists/) 的每條鏈結串列已排序，因此下一個最小值必在各串列前端。
- 核心狀態或轉換：Heap 只放每條未耗盡串列的第一個未輸出節點。
- 最容易出錯的地方：空串列、取出後忘記補 `next`，或把全部節點一次放進 heap。
- 一句話解法：反覆接上最小節點，再加入同一串列的下一個節點。
- 複雜度：`N` 為總節點數、`r` 為非空串列數，含掃描 `k` 個頭節點為 `O(k + N log(r + 1))` 時間、`O(r)` 額外 heap 空間；若重用原節點，不需另配置 `N` 個輸出節點。

### 綜合 Q295 Find Median from Data Stream

- 辨識理由：持續插入資料，且反覆查詢排序後的中間位置。見 [LeetCode Q295](https://leetcode.com/problems/find-median-from-data-stream/)。
- 核心狀態或轉換：Max-heap 存較小一半，min-heap 存較大一半。
- 最容易出錯的地方：只平衡數量卻沒維持兩半的大小關係，或平均值使用整數除法。
- 一句話解法：依分界插入並平衡兩堆，從一個或兩個堆頂取得中位數。
- 複雜度：已有 `n` 個值時新增 `O(log(n + 1))`、查詢 `O(1)`、總空間 `O(n)`。

## 常見錯誤與邊界條件

| 容易出錯的地方 | 檢查方式 |
| --- | --- |
| Top K heap 方向相反 | 堆頂應是「要淘汰者」；保留最大的 `k` 個用 min-heap |
| Heap 被當成排序陣列 | 用重複 `poll()` 或額外排序輸出；`for-each` 與 `toArray()` 不代表排序結果 |
| Comparator 用減法 | 改用 `compare` 或 `comparingInt/Long`，測試整數極值 |
| 同分順序未定義 | 題目要求先出現、字典序或索引時，加入次要比較鍵 |
| 直接修改在 heap 中的優先級 | 先取出再更新放回；任意位置更新需重新入堆或使用版本快照 |
| 空 heap 的回傳值被拆箱 | 先檢查 `isEmpty()`；取兩個之前確認 `size >= 2` |
| 第 `k` 大尚未存在 | 檢查 `1 <= k <= n`；資料流須先累積到 `k` 個 |
| 重複值被去除 | 先分清楚是元素排名、不同值排名，還是不同值的頻率排名 |
| 運算先溢位才轉型 | 用 `2L * x + y` 或先把候選存為 `long`，不是事後轉型 |
| `remove(Object)` 被誤算為對數時間 | 它需要線性搜尋；對 `PriorityQueue<Integer>`，`remove(1)` 是移除值 `1`，不是索引 `1` |
| Lazy heap 的大小被低估 | 分開計算有效候選數與實際保存的快照數 |

手動驗證至少涵蓋：空集合、單元素、`k = 1`、`k = n`、全相等、負數、遞增／遞減輸入、整數極值、多個空來源，以及中位數的奇偶切換。負數適用於 Top K、合併排序與中位數模板；合併成本模板仍依前述非負權重前提。

## 與相似 Pattern 的比較

| 方法 | 關鍵狀態與成本 | 選擇規則 |
| --- | --- | --- |
| Heap | 維護候選及堆頂；更新通常 `O(log h)` | 反覆取極值且候選持續變動，或只保存 Top K |
| Sorting | 建立完整順序；比較排序通常 `O(n log n)` | 靜態資料需要全部排序結果或多個排名 |
| Quickselect | 分割區間；隨機化期望 `O(n)`、最壞 `O(n²)` | 靜態資料只查一次排名，並可接受重排輸入；保留原陣列需複製 |
| Monotonic Deque | 保存未被支配且未過期的索引；總時間 `O(n)` | 固定視窗極值，插入與過期都依序發生 |
| TreeMap 加計數 | 維護不同值及次數；更新 `O(log u)` | 需要任意值刪除、前驅／後繼或兩端查詢，`u` 為不同值數 |
| Bucket Counting | 依有限分數範圍分桶；時間與值域大小有關 | 頻率介於 `1..n` 等可負擔的範圍，能以空間換掉 heap 比較 |

看到「視窗最大值」先評估 Monotonic Deque；看到「持續新增後查第 `k` 大」優先想固定容量 heap；只有一次靜態排名查詢，再比較 Quickselect 與 heap 的實作成本。

## 本週回顧

- 能否不看筆記寫出 Top K 與多路合併模板？
- 能否解釋為什麼第 `k` 大使用 min-heap，以及不足 `k` 個時為何不能回傳答案？
- 能否用一句話說出四種模型各自的 invariant？
- 能否區分「題目指定取極值」與「自己提出貪心規則，需要證明」？
- 雙堆插入後，如何同時保證分側正確與數量平衡？
- 解錯時，問題是在辨識、候選建模、正確性證明、comparator 還是更新順序？

個人錯題與心得：待補充。練習後記錄「原本的判斷、最小反例、修正後的 invariant」，不要只記下正確程式碼。

## 待複習項目

| 時間 | 練習 | 自我驗收 |
| --- | --- | --- |
| 1 天後 | Q1046、Q215 | 不看模板選對方向，口述每輪 heap 保存什麼 |
| 1 週後 | Q347、Q3066 | 說明比較鍵、`long` 的必要性，以及實際 heap 大小 |
| 1 個月後 | Q23、Q295，再重做錯題 | 寫出前端候選或雙堆 invariant，從操作次數推導複雜度 |

- [ ] 能從暴力反覆排序辨識出 heap 的機會。
- [ ] 能正確處理重複值、同分規則與空集合。
- [ ] 能說明 Top K 與完整排序的取捨。
- [ ] 能區分 heap 的結構保證與題目的正確性證明。
- [ ] 能檢查自己的複雜度是否漏算 map、輸出或過期資料。

## 一分鐘速查

- **辨識訊號**：反覆取極值、動態 Top K、多個排序來源、中位數資料流。
- **Heap 方向**：取最小用 min-heap；保留最大 `k` 個也用 min-heap，因為要淘汰其中最小者。
- **最重要的 invariant**：先說清楚 heap 應包含哪些候選，且比較鍵要保持有效；heap 只保證堆頂，不保證全體排序。
- **固定骨架**：Top K 加入後裁剪；合併極值取出後放回新值；多路合併只補同來源下一個；雙堆插入後平衡。
- **更新與邊界**：先檢查可取出的數量，不在 heap 內直接改鍵；用安全 comparator 和足夠寬的數字型別。
- **選擇規則**：動態極值用 heap；一次完整排序用 sort；固定視窗極值優先考慮 deque。
