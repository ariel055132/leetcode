# Prefix Sum Pattern

## 一句話定義

Prefix Sum 先保存「每個位置之前的累積狀態」，讓一段連續區間的資訊可以由兩個 prefix 相消，將重複的區間掃描從 `O(length)` 降成 `O(1)`。

最常用的定義是：

```text
prefix[0] = 0
prefix[i + 1] = prefix[i] + nums[i]

prefix[i] 代表 nums[0..i-1]，也就是前 i 個元素的總和。
sum(left, right) = prefix[right + 1] - prefix[left]
```

`prefix` 使用長度 `n + 1`，並把區間統一看成半開區間 `[left, right + 1)`，可以讓 `left = 0` 不需要特判。

---

## 適用情境

- 陣列或字串不會修改，卻要回答很多個連續區間查詢。
- 同一段資料會被重複計算，例如區間和、區間符合條件的元素數量。
- 題目問符合條件的 subarray 數量，可將區間條件改寫成兩個 prefix 的關係。
- 題目問最大／最小 subarray sum，可在掃描 prefix 時維護之前的極值。
- 累積操作可以消去共同前段，例如：
  - 加法：用減法消去。
  - XOR：再 XOR 一次消去。
  - 經過設計的字串數值：用位數和 `10` 的冪移除前段。
- 原始元素不是數字，但可以先轉成數值貢獻，例如符合條件記為 `1`，否則為 `0`。

## 不適用情境

- 陣列會頻繁更新：普通 prefix 修改一個元素後，後方狀態都失效；考慮 Fenwick Tree 或 Segment Tree。
- 只需從左到右算一次累積值，沒有區間相消或歷史狀態查詢：Running Sum 通常已足夠。
- 區間條件能靠左右指標單調調整：Sliding Window 可能更直接。
- 操作沒有適合的反操作。例：僅有 `prefixMin` 無法由兩個 prefix 求任意區間最小值。
- 題目只是在文字上提到 prefix。Q2996 的「longest sequential prefix」是陣列前段的定義，解法是順序掃描加 HashSet，不是典型 Prefix Sum Pattern。

---

## 題目辨識訊號

看到下列訊號時，先嘗試寫出區間與 prefix 的等式：

- `subarray`、`range [left, right]`、`queries`
- 多次詢問某個區間的 sum、count、XOR 或是否存在壞位置
- `sum equals k`、`number of subarrays`
- `maximum subarray sum`、`maximum absolute subarray sum`
- 每次 query 的範圍不同，但原始資料不變
- `n` 和 query 數都很大，逐 query 掃描會是 `O(nq)`

最關鍵的自問句：

> 我能否把 `[left, right]` 的答案寫成「截至 right 的累積狀態」減去或消去「left 之前的累積狀態」？

---

## 核心思維與 Invariant

### 維護的狀態

基本加法版本：

```text
prefix[i] = nums[0] + nums[1] + ... + nums[i - 1]
```

因此：

```text
prefix[right + 1]
= nums[0] + ... + nums[left - 1] + nums[left] + ... + nums[right]

prefix[right + 1] - prefix[left]
= nums[left] + ... + nums[right]
```

Invariant：處理完 `nums[i]` 後，`prefix[i + 1]` 恰好包含前 `i + 1` 個元素，不多也不少。

### 狀態如何更新

```java
prefix[i + 1] = prefix[i] + contribution(nums[i]);
```

`contribution` 是依題目調整的部分：

- 區間和：`nums[i]`
- 區間內符合條件的個數：符合為 `1`，否則為 `0`
- 區間內的違規相鄰邊數：該相鄰 pair 違規為 `1`，否則為 `0`
- 區間 XOR：改用 `prefix[i + 1] = prefix[i] ^ nums[i]`

### 為什麼不會遺漏答案

每個非空 subarray `[left, right]` 唯一對應一組 prefix 邊界：

```text
previousPrefix = prefix[left]
currentPrefix  = prefix[right + 1]
```

所以枚舉每個 `currentPrefix`，並查詢需要的 `previousPrefix`，就等於枚舉所有以目前位置結尾的候選 subarray；不必真的逐一往左掃描。

---

## 解題流程

1. 先寫暴力解法，確認重複掃描的是哪一段連續區間。
2. 定義每個元素（或每條相鄰邊）的 `contribution`。
3. 明確寫下 `prefix[i]` 代表什麼，優先採用前 `i` 個元素與長度 `n + 1`。
4. 把閉區間 `[left, right]` 改寫成半開區間 `[left, right + 1)`。
5. 推導兩個 prefix 如何相消，不要只憑記憶套 `right + 1`。
6. 依問題選擇保存方式：
   - 任意靜態區間查詢：prefix array
   - 尋找先前特定 prefix：HashMap
   - 只需要先前最小／最大 prefix：常數變數
   - 需要多種區間資訊：多組 prefix state
7. 檢查初始狀態、更新順序、整數溢位與空／單元素區間。

---

## 通用 Java 模板

### 1. 靜態區間和／區間計數

```java
public final class RangePrefix {
    private final long[] prefix;

    public RangePrefix(int[] nums) {
        prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // 可變部分：nums[i] 可以換成符合條件 ? 1 : 0
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public long query(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
```

固定骨架是 `n + 1`、`i + 1` 和 `right + 1 - left`；依題目調整的是每個位置的貢獻值。

建表 `O(n)`、每次 query `O(1)`、空間 `O(n)`。若只有一次 query，建表不一定比直接掃描划算。

### 2. Prefix XOR

```java
int[] prefixXor = new int[nums.length + 1];
for (int i = 0; i < nums.length; i++) {
    prefixXor[i + 1] = prefixXor[i] ^ nums[i];
}

int rangeXor = prefixXor[right + 1] ^ prefixXor[left];
```

因為 `x ^ x = 0`，共同前段會被消掉。建表 `O(n)`、每次 query `O(1)`、空間 `O(n)`。

### 3. Prefix Sum + Frequency Map

適合「計算多少個 subarray 滿足某個精確關係」。以區間和等於 `target` 為例：

```java
public int countSubarrays(int[] nums, int target) {
    Map<Long, Integer> frequency = new HashMap<>();
    frequency.put(0L, 1); // 空 prefix，讓從 index 0 開始的區間也能被計算

    long prefix = 0;
    int answer = 0;

    for (int num : nums) {
        prefix += num;

        // prefix - previousPrefix = target
        // previousPrefix = prefix - target
        answer += frequency.getOrDefault(prefix - target, 0);

        // 必須先查再加入，避免把目前 prefix 當成自己的歷史狀態
        frequency.put(prefix, frequency.getOrDefault(prefix, 0) + 1);
    }
    return answer;
}
```

平均時間 `O(n)`、最壞使用 `O(n)` 額外空間；`HashMap` 操作的 `O(1)` 是平均假設。若答案數量可能很大，`answer` 也應改用 `long`。

### 4. 維護先前 Prefix 的極值

最大 subarray sum：

```java
long prefix = 0;
long minPrefix = 0;
long answer = Long.MIN_VALUE;

for (int num : nums) {
    prefix += num;
    answer = Math.max(answer, prefix - minPrefix);
    minPrefix = Math.min(minPrefix, prefix);
}
```

Invariant：計算目前答案時，`minPrefix` 只包含目前右邊界之前可選的 prefix。必須「先算答案，再更新最小值」，才不會選到長度為 `0` 的區間；這對全負數陣列尤其重要。

時間 `O(n)`、額外空間 `O(1)`。

最大絕對 subarray sum：

```java
long prefix = 0;
long minPrefix = 0;
long maxPrefix = 0;

for (int num : nums) {
    prefix += num;
    minPrefix = Math.min(minPrefix, prefix);
    maxPrefix = Math.max(maxPrefix, prefix);
}

long answer = maxPrefix - minPrefix;
```

所有 subarray sum 都是兩個 prefix 的差；絕對值最大時，就是所有 prefix 中最大值與最小值的距離。

---

## 常見變形

### 1. 先轉換，再做 Prefix Sum

原資料不必直接相加。若題目問區間內符合 predicate 的數量，可先定義：

```java
int contribution = isValid(value) ? 1 : 0;
prefix[i + 1] = prefix[i] + contribution;
```

Q2559 就是把「字串以母音開始且結束」轉為 `1/0`，再回答區間 count。

### 2. 對相鄰邊做 Prefix Sum

有些題目查的是區間內每一對相鄰元素，而非元素本身。可令：

```text
bad[i] = nums[i - 1] 和 nums[i] 是否違規，i >= 1
```

對 `[left, right]` 而言，需要檢查的是邊 `left + 1 ... right`。若 `badPrefix[i]` 累積到第 `i` 條邊，則：

```text
badCount = badPrefix[right] - badPrefix[left]
```

`badCount == 0` 代表整段符合條件。Q3152 使用的就是這個模型。

### 3. 從「找區間」轉成「找先前 Prefix」

若：

```text
prefix[right + 1] - prefix[left] = k
```

移項可得：

```text
prefix[left] = prefix[right + 1] - k
```

因此掃描目前 prefix 時，用 HashMap 查詢先前出現過幾次 `currentPrefix - k`。Q560 是此變形的標準題。

### 4. Prefix 不一定要完整存下來

若未來只會問「目前 prefix 與先前最小／最大 prefix 的差」，不需要陣列或 HashMap：

- Q53：維護先前最小 prefix。
- Q1749：維護所有 prefix 的最小值與最大值。

選擇資料結構的原則是：只保存未來真的會查詢的歷史資訊。

### 5. 同時維護多種 Prefix State

一個 query 可能由數個可組合狀態共同決定。Q3756 的目前實作同時維護：

- `count[i]`：前 `i` 個字元中非零數字的數量。
- `val[i]`：前 `i` 個字元去掉 `0` 後串接成的數值（取模）。
- `prefixSumDigit[i]`：前 `i` 個字元的 digit sum。
- `pow10[i]`：`10^i mod MOD`。

區間非零數字的長度為 `len`，可用下式移除左側已串接的位數：

```text
x = val[right + 1] - val[left] * 10^len
digitSum = prefixSumDigit[right + 1] - prefixSumDigit[left]
```

取模減法可能為負，Java 中要正規化：

```java
x = (x % MOD + MOD) % MOD;
```

這類題的關鍵不是背公式，而是先寫清楚每個 prefix state 的語意，再推導如何移除共同前段。

---

## 代表題目（依目前 repo）

### 入門：Q303 Range Sum Query - Immutable

- 辨識理由：不可變陣列上有多次區間和查詢。
- 核心狀態或轉換：`prefix[i]` 是前 `i` 個元素總和。
- 最容易出錯的地方：閉區間右端需使用 `right + 1`。
- 一句話解法：建一次 prefix array，每次回傳 `prefix[right + 1] - prefix[left]`。
- 複雜度：初始化 `O(n)`，每次查詢 `O(1)`，空間 `O(n)`。

### 入門變形：Q1310 XOR Queries of a Subarray

- 辨識理由：多次詢問不可變陣列的區間 XOR。
- 核心狀態或轉換：加減法換成 XOR，利用 `x ^ x = 0`。
- 最容易出錯的地方：誤用減法，或漏掉 `right + 1`。
- 一句話解法：答案是 `prefixXor[right + 1] ^ prefixXor[left]`。
- 複雜度：建表 `O(n)`，每次查詢 `O(1)`，空間 `O(n)`。

### 標準：Q2559 Count Vowel Strings in Ranges

- 辨識理由：多次查詢區間內符合布林條件的元素數量。
- 核心狀態或轉換：每個 word 先映射為「首尾皆母音 ? `1` : `0`」。
- 最容易出錯的地方：單字首尾索引，以及區間端點。
- 一句話解法：對 predicate 的 `1/0` 結果建立 count prefix。
- 複雜度：預處理 `O(n)`，每次查詢 `O(1)`，空間 `O(n)`。

### 標準：Q3427 Sum of Variable Length Subarrays

- 辨識理由：每個右端點都要計算一段不同起點的區間和。
- 核心狀態或轉換：`start = max(0, i - nums[i])`，該段為 `prefix[i + 1] - prefix[start]`。
- 最容易出錯的地方：`start` 下界與包含 `nums[i]` 所需的 `i + 1`。
- 一句話解法：建表後，對每個 `i` 用一次區間查詢累加答案。
- 複雜度：時間 `O(n)`，空間 `O(n)`。

### 標準變形：Q3152 Special Array II

- 辨識理由：每次 query 要判斷區間內所有相鄰 pair 是否符合條件。
- 核心狀態或轉換：對「相鄰元素同奇偶」的壞邊建立 prefix count。
- 最容易出錯的地方：元素範圍 `[left, right]` 對應的邊是 `left + 1 ... right`；`left == right` 沒有邊，必定符合。
- 一句話解法：區間壞邊數為 `badPrefix[right] - badPrefix[left]`，等於 `0` 即為 special。
- 複雜度：預處理 `O(n)`，每次查詢 `O(1)`，空間 `O(n)`。

### 核心進階：Q560 Subarray Sum Equals K

- 辨識理由：要計數所有和恰好等於 `k` 的連續 subarray，且元素可能含負數。
- 核心狀態或轉換：在目前 prefix 查找過去的 `prefix - k` 出現次數。
- 最容易出錯的地方：忘記空 prefix `{0: 1}`、只記是否出現而沒記頻率、先加入再查詢。
- 一句話解法：掃描 prefix，答案加上 `frequency[prefix - k]`，再增加目前 prefix 的頻率。
- 複雜度：平均時間 `O(n)`，空間 `O(n)`。

### 進階：Q53 Maximum Subarray

- 辨識理由：最大化 `currentPrefix - previousPrefix`。
- 核心狀態或轉換：每個右端點只需減去它之前最小的 prefix。
- 最容易出錯的地方：全負數時答案不能初始化為 `0`；更新順序要保證區間非空。
- 一句話解法：先用 `prefix - minPrefix` 更新答案，再更新 `minPrefix`。
- 複雜度：時間 `O(n)`，額外空間 `O(1)`。

### 進階：Q1749 Maximum Absolute Sum of Any Subarray

- 辨識理由：最大化任意兩個 prefix 差的絕對值。
- 核心狀態或轉換：答案是所有 prefix 的 `maxPrefix - minPrefix`。
- 最容易出錯的地方：沒有把空 prefix `0` 納入最大／最小值。
- 一句話解法：掃描累積和並維護 prefix 全域最小值與最大值。
- 複雜度：時間 `O(n)`，額外空間 `O(1)`。

### 綜合：Q3756（題名待核對）

- 辨識理由：多次 query 同時需要區間非零 digit 串接值與 digit sum。
- 核心狀態或轉換：用 count、串接值、digit sum、`10` 的冪四種前綴狀態共同還原區間答案。
- 最容易出錯的地方：移除左 prefix 時使用的是區間內非零 digit 數量，以及模數減法可能為負。
- 一句話解法：用代數移除串接值的共同前段，再乘上區間 digit sum。
- 複雜度：預處理 `O(n)`，每次查詢 `O(1)`，空間 `O(n)`。

---

## Worked Example：Q560

```text
nums = [1, 1, -1], k = 1
初始 frequency = {0: 1}

讀 1：prefix = 1，需要 0，找到 1 次，answer = 1；加入 prefix 1
讀 1：prefix = 2，需要 1，找到 1 次，answer = 2；加入 prefix 2
讀 -1：prefix = 1，需要 0，找到 1 次，answer = 3；prefix 1 的頻率變 2
```

三段答案分別是 `[0,0]`、`[1,1]`、`[0,2]`。HashMap 保存頻率而非 boolean，是因為相同 prefix 可能由不同左邊界產生不同 subarray。

---

## 常見錯誤與邊界條件

1. **Prefix 定義不一致**
   - 一下把 `prefix[i]` 當成包含 `nums[i]`，一下又當成前 `i` 個元素。
   - 建議固定：`prefix[i]` 代表 `[0, i)`。

2. **Off-by-one**
   - 閉區間 `[left, right]` 的右 prefix 是 `right + 1`。
   - 單元素 `[i, i]` 應得到 `prefix[i + 1] - prefix[i]`。

3. **忘記 identity prefix**
   - 加法與 XOR 的 identity 都是 `0`。
   - 沒有 `prefix[0]`，從 index `0` 開始的區間就需要特判或可能漏算。

4. **HashMap 初始化或更新順序錯誤**
   - `frequency.put(0, 1)` 代表尚未取任何元素的 prefix。
   - 先查歷史、後放目前 prefix，避免錯算空 subarray。

5. **只存存在與否，卻忘記題目要計數**
   - 同一 prefix 出現多次，代表有多個可選左邊界；Q560 必須保存頻率。

6. **負數時誤用 Sliding Window**
   - 加入負數可能讓 sum 下降，移動左界也不再具有單調性；Prefix Sum + HashMap 仍然有效。

7. **整數溢位**
   - `nums[i]` 是 `int` 不代表 prefix、答案或 subarray 數量仍能放進 `int`。
   - 通用模板優先考慮 `long`，再依題目回傳型別轉換。

8. **把元素條件與邊條件混在一起**
   - Q2559 累積元素；Q3152 累積相鄰 pair。先畫出 query 真正涵蓋的索引。

9. **模數減法為負**
   - Java 的 `%` 可能保留負號，使用 `(value % MOD + MOD) % MOD` 正規化。

10. **空陣列／單元素／全負數**
    - 先確認題目是否允許空陣列或空 subarray。
    - 最大非空 subarray 的答案不能預設為 `0`。

---

## 與相似 Pattern 的比較

| 判斷面向 | Prefix Sum | Running Sum | Sliding Window | Difference Array | Fenwick / Segment Tree |
|---|---|---|---|---|---|
| 主要用途 | 靜態區間查詢、subarray 關係 | 單次由左到右累積 | 找可單調調整的連續視窗 | 多次區間更新 | 動態更新與區間查詢 |
| 維護狀態 | 每個邊界的累積值或其摘要 | 目前累積值 | 左右界與視窗內狀態 | 邊界變化量 | 樹狀分段資訊 |
| 常見複雜度 | 建表 `O(n)`，query `O(1)` | `O(n)`、空間 `O(1)` | 通常 `O(n)` | 更新 `O(1)`，最後還原 `O(n)` | 操作 `O(log n)` |
| 負數 | 可處理 | 可處理，但不能直接回答任意區間 | 常破壞 sum 的單調性 | 可處理 | 可處理 |
| 選擇條件 | 資料不變、重複 query，或可寫成 prefix 關係 | 只要一次掃描結果 | 視窗可依條件安全縮放 | 主要操作是批次 range update | 原資料會更新 |

Prefix Sum 與 Kadane 的選擇：Q53 可用兩者解。Kadane 維護「以目前位置結尾的最佳 subarray」，Prefix Sum 維護「目前 prefix 減去先前最小 prefix」。若題目延伸到 prefix pair、區間查詢或 HashMap 關係，Prefix Sum 的建模較容易延伸；只求 Maximum Subarray 時，Kadane 通常更直接。

可操作的選擇規則：

- 多次靜態區間查詢：先想 Prefix Sum。
- 有負數且要計數精確 subarray sum：Prefix Sum + HashMap。
- 全為非負數且條件能隨視窗擴張／收縮單調變化：評估 Sliding Window。
- 多次區間加值、最後一次輸出：Difference Array。
- 更新與查詢交錯：Fenwick Tree 或 Segment Tree。

---

## 一分鐘速查

- 訊號：`subarray`、`[left, right]`、大量 queries、區間 sum/count/XOR、和等於 `k`。
- 定義：`prefix[i]` 是前 `i` 個元素，即 `[0, i)` 的累積狀態。
- 核心 invariant：`prefix[i + 1]` 比 `prefix[i]` 多且只多第 `i` 個 contribution。
- 區間公式：`range(left, right) = prefix[right + 1] - prefix[left]`。
- XOR 公式：`prefixXor[right + 1] ^ prefixXor[left]`。
- 計數公式：若 `current - previous = k`，就查 `previous = current - k`。
- HashMap：初始 `{0: 1}`，一定先查再更新頻率。
- 最大 subarray：目前 prefix 減去「之前」最小 prefix；全負數時答案不可設 `0`。
- 邊條件：元素 `[left, right]` 內的相鄰邊是 `left + 1 ... right`。
- 選擇規則：負數讓 Sliding Window 失去單調性時，優先評估 Prefix Sum。

---

## 本週回顧

- [ ] 能否不看筆記寫出 `n + 1` 的基本模板？
- [ ] 能否用一句話說明 `prefix[right + 1] - prefix[left]` 為何成立？
- [ ] 能否把 Q2559 的字串條件轉成 `1/0 contribution`？
- [ ] 能否畫出 Q3152 的「元素索引」與「相鄰邊索引」？
- [ ] 能否不看答案推導 Q560 要找的是 `currentPrefix - k`？
- [ ] 能否說明 Q560 為何存 frequency、為何先查再加入？
- [ ] 能否說明 Q53 更新 `answer` 與 `minPrefix` 的順序？
- [ ] 能否判斷何時該用 Sliding Window、Difference Array 或 Fenwick Tree？

## 待複習項目

- **1 天後**：默寫基本區間模板與 Prefix + HashMap 模板；重做 Q303、Q560。
- **1 週後**：不看分類重做 Q3152、Q53，說出兩題各自維護的 invariant。
- **1 個月後**：重做 Q1749 與 Q3756，練習自行設計需要維護的 prefix state。
- **待補充**：每次錯題後記錄錯在「辨識、建模、證明、更新順序、邊界或型別」哪一層。
