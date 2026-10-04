# Tree Pattern

這份筆記以二元樹與 Binary Search Tree（BST）為主，使用 Java 17 與 repo 的 [TreeNode](TreeNode.java)。學習順序是先定義遞迴函式的意義，再選 DFS、BFS 或 BST 的有序性；重點是能從題目推導狀態與更新順序，而不只是背走訪程式。

## 一句話定義

Tree Pattern 利用「一棵樹由根與較小的子樹組成」的結構，把問題轉成向下傳遞路徑資訊、向上合併子樹答案，或逐層處理節點。

## 適用情境

- 輸入有 `root`、`left`、`right`，答案可由左右子樹的結果合併。
- 要計算高度、節點數、子樹總和、平衡性或最長路徑。
- 條件與祖先或根到目前節點的路徑有關，例如路徑和、沿路最大值。
- 要按層輸出、找最靠近根的葉節點，或計算每層統計。
- 題目保證是 BST，可利用整個左子樹較小、整個右子樹較大的性質。
- 要比較兩棵樹、找共同祖先，或從走訪序列重建樹。

## 不適用情境

- 資料可能有環或同一節點有多個父節點：已超出普通樹的假設，需用 Graph 的防重訪、拓撲排序或其他狀態處理。
- 題目是一般二元樹，卻想依數值大小排除某側：沒有 BST 保證時不能這樣剪枝。
- 題目只要動態最大／最小值或 Top K：通常考慮 [Heap Pattern](../Heap/README.md)，不必自己建立搜尋樹。
- 需要陣列的區間更新與查詢：應評估 Fenwick Tree 或 Segment Tree，這裡的二元樹走訪模板不能直接取代它們。

## 題目辨識訊號

| 題目訊號 | 需要的資訊 | 優先考慮 |
| --- | --- | --- |
| 深度、子樹總和、是否平衡 | 左右子樹先給答案，父節點再合併 | Postorder DFS |
| 根到葉、祖先限制、沿途最大值 | 父節點把目前路徑狀態傳給孩子 | Top-down DFS |
| 列出所有根到葉路徑 | 目前路徑，離開分支時需還原 | DFS 加 Backtracking |
| 每層、右視圖、最近的葉節點 | 按距離根的層數處理 | BFS |
| BST 搜尋、範圍、排名 | 有序性、合法上下界或 inorder 次序 | BST 剪枝或 Inorder |
| 相同樹、鏡像樹 | 兩個節點之間的配對關係 | 雙節點遞迴 |
| 共同祖先 | 兩個目標分別出現在哪些子樹 | 合併子樹搜尋結果 |
| Preorder 與 inorder 重建 | 根的位置、左右子樹的索引範圍 | Divide and Conquer |

最關鍵的自問句：

> 如果左右子樹的答案都已經知道，我能算出目前節點的答案嗎？如果不能，是不是還需要把祖先資訊往下傳？

## 核心思維與 Invariant

### 先統一名詞與前提

- `n`：節點總數；`h`：最長根到葉路徑的節點數；`w`：同一層最多的節點數。
- 本文以節點數表示高度：空樹高度 `0`，葉節點高度 `1`。若題目以邊數計算長度，要另行轉換。
- 葉節點必須同時滿足 `left == null && right == null`；只有一個孩子不算葉節點。
- 範例假設輸入是合法、無環且不共用子節點的樹；只沿 `left/right` 向下走時，不需要 `visited`。
- 一般二元樹可有重複值。本文的 BST 驗證採嚴格大小關係，不接受重複鍵；其他 BST 題目要重新確認規則。

### 維護的狀態

先用一句話定義函式契約，區分三種狀態：

| 狀態種類 | 函式契約或 invariant | 例子 |
| --- | --- | --- |
| 向下傳遞的參數 | 進入節點時，參數精確描述根到父節點的資訊 | 剩餘目標和、祖先最大值、BST 上下界 |
| 向上回傳的摘要 | 函式回傳時，結果完整描述以目前節點為根的子樹 | 高度、總和、是否平衡 |
| 共用且可修改的路徑 | 進入前是根到父節點，加入後是根到目前節點，返回前恢復原狀 | `List<Integer> path` |

例如 `height(node)` 應只表示「這棵子樹的高度」，不要一會兒回傳高度、一會兒回傳從整棵樹根累積的深度。若需要多項結果，用具名欄位一起回傳。

### 狀態如何更新

Preorder、inorder、postorder 的差別，是**處理目前節點的時機**，不是三種互不相干的演算法。

| 次序 | 處理順序 | 常見用途 |
| --- | --- | --- |
| Preorder | 根 → 左 → 右 | 先決定孩子需要的狀態、複製或編碼樹 |
| Inorder | 左 → 根 → 右 | BST 的有序枚舉；一般二元樹不保證有序 |
| Postorder | 左 → 右 → 根 | 等左右結果齊備，再計算子樹摘要 |
| Level order | 逐層，層內由左到右 | 分層輸出、最小根到葉距離 |

同一個 DFS 可以在往下時更新參數，在回來時合併結果，不必強迫整道題只屬於其中一種次序。

### 為什麼不會遺漏答案

對子樹問題可用結構歸納：先定義空樹的正確答案；假設左右子樹都正確，再證明合併式能得到目前子樹的答案。根、左子樹、右子樹涵蓋所有節點，且彼此不重複。

路徑 DFS 利用每個節點只有一條根到該節點的路徑，進入左右分支時分別延伸路徑狀態。BFS 則維持「每輪開始時 queue 恰好是目前這一層」；處理完整層後，留下的就是下一層。

BST 的剪枝另有前提：大小限制必須對整個子樹成立，只比較父節點與直接孩子不夠。

## 解題流程

1. 確認是一般二元樹、BST、N-ary Tree，還是用無向邊表示的樹。
2. 確認答案對象：單一節點、整個子樹、根到葉路徑、任意兩點路徑，或某一層。
3. 寫出 helper 的一句話契約，明確區分傳入參數與回傳值。
4. 決定空節點與葉節點的行為，不要把兩者混為一談。
5. 根據資訊的依賴方向，選 top-down、postorder、inorder 或 BFS。
6. 寫出狀態更新與還原順序，檢查左右分支是否意外共用已修改的資料。
7. 檢查數值範圍、BST 的嚴格邊界，以及跨多次呼叫殘留的欄位。
8. 以節點造訪次數計算時間，以高度、寬度與輸出量分別計算空間。

## 通用 Java 模板

以下完整類別可各自放入同名 `.java` 檔，搭配共用匯入與 repo 的 `Tree.TreeNode`。不修改原樹，且每次呼叫都建立自己的工作狀態。

```java
import Tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
```

### 模板一 Postorder 合併子樹摘要

一次回傳高度與平衡性，示範如何讓父節點取得它真正需要的資訊。

```java
public final class SubtreePattern {
    public record Summary(int height, boolean balanced) {}

    public static Summary analyze(TreeNode node) {
        if (node == null) {
            return new Summary(0, true); // 可變：空子樹的摘要
        }

        Summary left = analyze(node.left);
        Summary right = analyze(node.right);

        // 可變：如何合併左右子樹；固定：先取得兩邊的結果
        int height = 1 + Math.max(left.height(), right.height());
        boolean balanced = left.balanced() && right.balanced()
            && Math.abs(left.height() - right.height()) <= 1;
        return new Summary(height, balanced);
    }
}
```

- 固定骨架：空樹回傳 identity → 遞迴取得左右摘要 → 合併並回傳。
- 可變部分：摘要的欄位、空樹定義與合併公式。例如節點數是 `1 + leftCount + rightCount`，總和是 `node.val + leftSum + rightSum`。
- Invariant：`analyze(node)` 回傳的高度與平衡性，都只描述以 `node` 為根的子樹。
- 複雜度：每個節點合併一次，每次 `O(1)`，時間 `O(n)`；遞迴與仍需保存的摘要佔 `O(h)` 額外空間。

若只要最大深度，摘要可簡化成一個 `int`。若需要總和，依資料範圍使用 `long`。不要在每個節點重新完整計算左右高度，才又遞迴檢查同一批節點。

### 模板二 向下傳遞路徑狀態與回溯

同一種路徑問題，只有數值狀態時可按值傳遞；要保存實際路徑時，才需要管理可修改的列表。

```java
public final class PathPattern {
    // 契約：是否存在從 node 到葉節點、總和為 remaining 的路徑
    public static boolean hasPathSum(TreeNode node, long remaining) {
        if (node == null) {
            return false;
        }
        long next = remaining - node.val;
        if (node.left == null && node.right == null) {
            return next == 0;
        }
        return hasPathSum(node.left, next) || hasPathSum(node.right, next);
    }

    public static List<List<Integer>> rootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    private static void collect(TreeNode node, List<Integer> path,
                                List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val); // 固定：進入分支
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path)); // 保存當下快照
        } else {
            collect(node.left, path, result);
            collect(node.right, path, result);
        }
        path.remove(path.size() - 1); // 固定：離開前還原，包括葉節點
    }
}
```

- `hasPathSum` 的可變部分是累積規則與成功條件；根到葉的題目只能在真正的葉節點接受答案。`long` 參數在各次呼叫中獨立，不需要回溯還原；運算仍須在 `long` 可表示範圍內。
- `collect` 的固定骨架是加入 → 探索／保存答案 → 移除；可變部分是何時收集、路徑保存什麼，以及是否加入其他條件。
- `result.add(path)` 只保存同一列表的參考，後續回溯會改掉答案；必須複製快照。
- 存在性判斷最壞時間 `O(n)`、額外空間 `O(h)`。列舉路徑令 `L` 為所有輸出路徑長度總和，時間為 `O(n + L)`、工作空間 `O(h)`、輸出空間 `O(L)`，不能忽略複製成本。

若有負數，不能因為目前累積和超過目標就停止；後面的負數仍可能把總和降回目標。

例如 `[10, -5]` 這條根到葉路徑的總和是 `5`，在根節點看到 `10 > 5` 時不能剪枝。

### 模板三 BFS 固定本層大小

```java
public final class LevelOrderPattern {
    public static List<List<Integer>> levels(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 固定：先保存本層大小
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.removeFirst();
                level.add(node.val); // 可變：本層的統計或選擇規則
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
```

Invariant：每輪開始時 queue 只含本層；迴圈中可能同時含本層尚未處理的節點與下一層。不能用不斷變動的 `queue.size()` 當這一層的迴圈上限。

固定骨架是取出本層的 `levelSize` 個節點，再進入下一層；可變部分可以是本層總和、最大值或最右節點。最小深度則在第一次取出葉節點時回傳目前層數。

每個節點進出 queue 各一次，時間 `O(n)`；queue 佔 `O(w)`，此模板另有 `O(n)` 輸出。`ArrayDeque` 的兩端操作為攤銷 `O(1)`，且不接受 `null`，所以只加入非空孩子。見 [Java 17 ArrayDeque 文件](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayDeque.html)。

### 模板四 迭代 Inorder

顯式 stack 保存「之後還要回來處理」的祖先，避免依賴 Java 的遞迴呼叫堆疊。

```java
public final class InorderPattern {
    public static List<Integer> values(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val); // 可變：造訪目前節點時的工作
            current = current.right;
        }
        return result;
    }
}
```

固定骨架是一路向左 → 回到祖先並處理 → 轉向右子樹；可變部分是 `result.add` 的工作。每次走完向左的迴圈後，堆頂就是 inorder 下一個待處理節點，其左子樹已經處理完。

時間 `O(n)`、stack 空間 `O(h)`、輸出空間 `O(n)`。若輸入是合法 BST，可改成每次造訪將 `k` 減一，第 `k` 次立即回傳；對合法的 `1 <= k <= n`，時間為 `O(h + k)`、額外空間 `O(h)`。一般二元樹的 inorder 只是一種走訪順序，不能拿它當排序結果。

### 模板五 BST 傳遞祖先上下界

```java
public final class BstBoundsPattern {
    public static boolean isValid(TreeNode root) {
        return within(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean within(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return within(node.left, lower, node.val)
            && within(node.right, node.val, upper);
    }
}
```

Invariant：`within(node, lower, upper)` 要驗證整棵子樹都遵守祖先累積的開區間限制。左子樹縮小上界，右子樹提高下界；使用 `long` 邊界，才能容納合法的 `Integer.MIN_VALUE` 與 `Integer.MAX_VALUE`。

固定骨架是檢查目前值 → 傳遞收緊的界限；可變部分是重複鍵的政策與資料型別。若節點本身是 `long`，不能再拿 `Long.MIN_VALUE` 當超出值域的哨兵，應使用可缺省的邊界或另外保存「是否有界限」。最壞時間 `O(n)`、額外空間 `O(h)`。

## Worked Example 同一棵樹的不同資訊方向

```text
        8
       / \
      3   10
     / \    \
    1   6    14
```

| 走訪方式 | 結果 |
| --- | --- |
| Preorder | `8, 3, 1, 6, 10, 14` |
| Inorder | `1, 3, 6, 8, 10, 14` |
| Postorder | `1, 6, 3, 14, 10, 8` |
| BFS | `[[8], [3, 10], [1, 6, 14]]` |

用 postorder 計算摘要時，先完成孩子，再回傳給父節點：

| 子樹根 | 左高度 | 右高度 | 回傳高度 | 是否平衡 |
| --- | --- | --- | --- | --- |
| `1`、`6`、`14` | `0` | `0` | `1` | 是 |
| `3` | `1` | `1` | `2` | 是 |
| `10` | `0` | `1` | `2` | 是 |
| `8` | `2` | `2` | `3` | 是 |

判斷是否存在和為 `17` 的根到葉路徑時，`remaining` 依序為 `17 → 9 → 6 → 0`，對應選取 `8 → 3 → 6`；最後位於葉節點，才能接受。

列舉路徑時，探索 `1` 後必須把 `[8, 3, 1]` 還原成 `[8, 3]`，才能再探索 `6` 並得到 `[8, 3, 6]`。葉節點保存的是快照，不會隨著回溯變成空列表。

若把 `6` 改成 `9`，它仍大於直接父節點 `3`，但已違反祖先 `8` 的左子樹上界。BST 驗證要傳遞祖先限制，不能只檢查相鄰兩層。

## 常見變形

### 最大深度與最小深度的空孩子不同

最大深度可以直接取 `1 + max(leftHeight, rightHeight)`。最小深度卻不能無條件取 `1 + min(leftDepth, rightDepth)`，因為不存在的孩子不是一條到葉節點的路徑。

只有一個非空孩子時，必須沿著那一側繼續；兩側都有孩子時才取較小者。也可用 BFS 找第一個葉節點。這是 [Q111 Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) 的關鍵邊界，可對照 [repo 題解](Q111.java)。

### 回傳給父節點的路徑與子樹內最佳答案不同

以 [Q543 Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) 為例，直徑以邊數計算，且不一定通過整棵樹的根。可回傳 `(height, diameter)`：

```text
height   = 1 + max(left.height, right.height)
through  = left.height + right.height
diameter = max(left.diameter, right.diameter, through)
```

空子樹回傳 `(0, 0)`。這裡的 height 以節點數計算，所以左右 height 相加剛好是穿過目前節點的邊數。父節點若要繼續延伸路徑，只能接一條向下分支，不能把已經分叉的完整直徑接上去。此模型每個節點做固定次數合併，時間 `O(n)`、額外空間 `O(h)`。

### 同時比較兩個節點

相同樹把 `a.left` 對 `b.left`、`a.right` 對 `b.right`；鏡像樹則把 `a.left` 對 `b.right`、`a.right` 對 `b.left`。先處理兩者都空、只有一者為空，再比較值與子樹。

可對照 [repo Q100](Q100.java) 與 [repo Q101](Q101.java)。狀態是節點配對，不應只把兩棵樹的數值走訪結果拿來比較；若未保留空節點位置，相同序列可能來自不同形狀。

### Lowest Common Ancestor 合併目標所在方向

對一般二元樹，可讓 helper 回傳在子樹找到的目標，或已確定的共同祖先：

```text
node 為空                  → 回傳 null
node 就是 p 或 q           → 回傳 node
遞迴取得 left 與 right
兩側都非空                 → 回傳 node
只有一側非空               → 回傳那一側
兩側都空                   → 回傳 null
```

這個簡潔版本依賴兩個目標都存在於樹中的前提，[Q236 Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) 提供此保證。如果題目沒有保證，要額外驗證兩者是否找到，不能把唯一找到的目標直接當答案。比較的是節點身分，例如 `node == p`；一般樹中相同數值未必是同一節點。

一般二元樹的搜尋最壞 `O(n)` 時間、`O(h)` 空間。只有在輸入已保證為 BST 且符合其鍵值規則時，才能利用兩個目標相對於目前值的大小，沿單一方向搜尋到分岔點，時間 `O(h)`。

### 由走訪序列重建樹

在值互不重複、兩個序列合法且來自同一棵樹的前提下，preorder 的第一個值是根，根在 inorder 的位置把左右子樹分開。可先建立 `value → inorder index` 的 map，再用索引範圍遞迴：

```text
build(preStart, inStart, length)
length == 0 → null
rootValue = preorder[preStart]
pivot = inorderIndex[rootValue]
leftSize = pivot - inStart

left  = build(preStart + 1,            inStart,   leftSize)
right = build(preStart + 1 + leftSize, pivot + 1, length - leftSize - 1)
```

若 hash 查詢平均 `O(1)`，時間為 `O(n)`、map 空間 `O(n)`、遞迴空間 `O(h)`，另需 `O(n)` 建立輸出樹。若每層都線性找根並複製子陣列，偏斜樹的時間可能變成 `O(n²)`。重複值則不能直接用單一 index map 唯一決定切割位置。

### N-ary Tree 與無向邊表示的樹

N-ary Tree 把固定的左右遞迴改成遍歷所有孩子，合併高度或總和的思路不變；但沒有二元樹通用的「左 → 根 → 右」inorder 定義。

若輸入是無向樹的 adjacency list，每條邊在兩端都出現，DFS 要傳入 `parent` 並跳過它，否則會沿原邊走回去。只有已保證是樹時，跳過 parent 才足夠；一般圖還要管理 `visited` 或其他防重訪狀態。

## 代表題目

以下以 repo 已有的練習為主，依學習順序排列。複雜度會區分本筆記的模板與 repo 現有寫法，避免把改良方法的成本套到不同實作。

### 入門 Q104 Maximum Depth of Binary Tree

- 辨識理由：答案是左右子樹高度最大值加一；題目以路徑節點數定義深度。見 [LeetCode Q104](https://leetcode.com/problems/maximum-depth-of-binary-tree/)。
- 核心狀態或轉換：`height(null) = 0`，回傳目前子樹高度，可對照 [repo 題解](Q104.java)。
- 最容易出錯的地方：把節點數與邊數混用，或誤以為所有樹的高度都是 `log n`。
- 一句話解法：Postorder 取得左右高度，再回傳 `1 + max(left, right)`。
- 複雜度：時間 `O(n)`、額外空間 `O(h)`。

### 入門 Q112 Path Sum

- 辨識理由：判斷是否有根到葉路徑符合總和，條件需要一路往下傳。見 [LeetCode Q112](https://leetcode.com/problems/path-sum/)。
- 核心狀態或轉換：`remaining` 表示從目前節點開始還需要的總和，可對照 [repo 題解](Q112.java)。
- 最容易出錯的地方：內部節點總和已達標就回傳成功，或把空樹且目標 `0` 當成合法路徑。
- 一句話解法：扣掉目前值，把剩餘目標傳給孩子，只在葉節點檢查是否為 `0`。
- 複雜度：最壞時間 `O(n)`、額外空間 `O(h)`；只問存在性時不需保存路徑列表。

### 標準 Q102 Binary Tree Level Order Traversal

- 辨識理由：輸出要求逐層、層內由左到右。見 [LeetCode Q102](https://leetcode.com/problems/binary-tree-level-order-traversal/)。
- 核心狀態或轉換：每輪開始先記錄 queue 大小，可對照 [repo 題解](Q102.java)。
- 最容易出錯的地方：在處理本層時把剛加入的下一層節點也算進來。
- 一句話解法：Queue 每次只處理本層固定數量，孩子留給下一輪。
- 複雜度：時間 `O(n)`、queue 空間 `O(w)`、輸出空間 `O(n)`。

### 標準變形 Q110 Balanced Binary Tree

- 辨識理由：不只根節點，每個子樹都必須符合高度平衡條件。見 [LeetCode Q110](https://leetcode.com/problems/balanced-binary-tree/)。
- 核心狀態或轉換：一次 postorder 同時回傳高度與平衡性。
- 最容易出錯的地方：只檢查目前左右高度差，漏掉子樹內部已經不平衡。
- 一句話解法：左右子樹都平衡，且兩側高度差不超過一，目前子樹才平衡。
- 複雜度：摘要模板時間 `O(n)`、額外空間 `O(h)`。[repo 題解](Q110.java) 把高度計算與平衡檢查分開，有重複走訪，不應直接套用一次 postorder 的分析。

### 標準變形 Q98 Validate Binary Search Tree

- 辨識理由：每個節點都受祖先的嚴格大小限制，而不只是直接父節點。見 [LeetCode Q98](https://leetcode.com/problems/validate-binary-search-tree/)。
- 核心狀態或轉換：傳遞合法開區間 `(lower, upper)`；也可驗證 inorder 是否嚴格遞增。
- 最容易出錯的地方：漏掉遠端祖先限制，或把合法的整數最小值當成「尚未有前一值」的哨兵。
- 一句話解法：逐節點檢查上下界，再把左側上界、右側下界收緊為目前值。
- 複雜度：範圍模板最壞時間 `O(n)`、額外空間 `O(h)`；[repo 題解](Q98.java) 保存完整 inorder 結果，另需 `O(n)` 列表空間。

### 標準變形 Q230 Kth Smallest Element in a BST

- 辨識理由：合法 BST 的 inorder 可依序列出排名。見 [LeetCode Q230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)。
- 核心狀態或轉換：迭代 inorder 的 stack 加上還需造訪的次數 `k`。
- 最容易出錯的地方：把 `k` 當零起始索引，或未利用第 `k` 次造訪就可停止的條件。
- 一句話解法：依 inorder 造訪，每次扣一，第 `k` 個節點就是答案。
- 複雜度：提前停止版本時間 `O(h + k)`、空間 `O(h)`；[repo 題解](Q230.java) 先建立完整列表，時間與列表空間皆為 `O(n)`。

### 綜合 Q105 Construct Binary Tree from Preorder and Inorder Traversal

- 辨識理由：一個序列決定根，另一個決定左右子樹的分界。見 [LeetCode Q105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)。
- 核心狀態或轉換：`preStart`、`inStart`、`length` 定義同一棵待建子樹；題目保證值互不重複。
- 最容易出錯的地方：右子樹 preorder 起點忘了跳過根及整棵左子樹。
- 一句話解法：找根在 inorder 的位置，算出左子樹大小，再切出左右遞迴範圍。
- 複雜度：index map 與索引範圍版本平均時間 `O(n)`、額外工作空間 `O(n)`，另有 `O(n)` 輸出樹；[repo 題解](Q105.java) 使用線性搜尋及陣列複製，偏斜樹時間可能達到 `O(n²)`。

## 常見錯誤與邊界條件

| 容易出錯的地方 | 檢查方式 |
| --- | --- |
| 沒有定義 helper 的回傳意義 | 先寫「回傳以 node 為根的子樹的什麼」，再寫遞迴 |
| 把 `null` 當葉節點 | 葉節點本身存在，且兩個孩子都為空 |
| 最小深度走向不存在的孩子 | 單側為空時，只考慮非空子樹 |
| 把一般二元樹當 BST | 只有題目保證有序性時才能依大小剪枝 |
| BST 只比較直接孩子 | 使用祖先上下界，或驗證完整 inorder 的嚴格遞增 |
| 路徑未還原或答案共用列表 | 每次進入對應一次退出移除，保存答案時複製 |
| BFS 層數混在一起 | 每輪開始先保存 `levelSize`，且不要將 `null` 加入 `ArrayDeque` |
| 共用欄位污染下次呼叫 | 每次入口重設計數、結果、前一值；優先用局部狀態或回傳摘要 |
| 整數溢位與錯誤哨兵 | 路徑和用足夠寬的型別；合法極值不可同時代表未初始化 |
| 忽略偏斜樹 | `h` 可達 `n`；深遞迴可能造成 `StackOverflowError`，可用顯式 stack 或 queue |
| 每層重新掃子樹或複製陣列 | 將每個節點的所有工作加總，不是看見 DFS 就宣稱 `O(n)` |
| 用節點值代替身分 | 一般樹允許重複值，祖先與結構問題應辨識節點本身 |

手動驗證至少涵蓋：空樹、單節點、只有左／右孩子的鏈、寬而淺的樹、重複值、負數、整數極值、內部節點達標但葉節點不達標的路徑，以及只違反遠端祖先的 BST。使用有欄位的解法時，也要連續呼叫同一物件兩次。

## 複雜度如何判斷

| 實作方式 | 時間 | 額外空間與成立條件 |
| --- | --- | --- |
| 每節點做 `O(1)` 工作的 DFS | `O(n)` | `O(h)`，包含遞迴堆疊 |
| 按層 BFS | `O(n)` | Queue 為 `O(w)`；儲存所有結果另加 `O(n)` |
| BST 沿單一路徑搜尋 | `O(h)` | 迭代可為 `O(1)`；平衡時才有 `h = O(log n)` |
| 列舉根到葉路徑 | `O(n + L)` | 工作空間 `O(h)`、輸出 `O(L)` |
| 對每個節點重新完整掃描其子樹 | `O(nh)` 上界 | 偏斜樹且未提早停止時，可累積為 `O(n²)` |

遞迴「有兩次子呼叫」不代表時間一定是 `O(2^n)`；普通樹的左右子樹互不重疊，若每個節點只處理一次，總工作量仍是線性。反過來，遞迴深度也不一定是 `log n`：鏈狀樹有 `h = n`，DFS 空間可為 `O(n)`，而 BFS queue 可維持 `O(1)`。

## 與相似 Pattern 的比較

| 方法 | 維護的狀態 | 選擇規則 |
| --- | --- | --- |
| Top-down DFS | 根到目前位置的狀態 | 條件依賴祖先、路徑或累積限制 |
| Postorder DFS | 每個子樹的摘要 | 父節點必須先知道孩子的答案 |
| BFS | 同一層的待處理節點 | 題目要求分層或最近的葉節點 |
| Backtracking | 可修改且需要還原的路徑 | 要列舉具體路徑或選擇；單純傳數值不一定需要還原 |
| BST 搜尋 | 祖先區間或有序走訪位置 | 輸入有 BST 保證，可跳過整棵不可能的子樹 |
| Graph Traversal | 節點與防重訪狀態 | 有環、多個到達路徑，或資料不再保證是樹 |
| Tree DP | 每個子樹的一組狀態 | 回傳值需要描述多個選擇，例如選／不選目前節點 |

Tree DP 常以 postorder 合併，兩者不是互斥選項。普通樹的子樹不重疊，若每個狀態只算一次，不必為了「有遞迴」就加入 memoization。先判斷資訊流向，再選走訪方式；確定是 BST 後，才使用有序性的額外優勢。

## 本週回顧

- 能否不看筆記，先用一句話定義 helper，再寫出 DFS 或 BFS？
- 能否說明 top-down 參數、postorder 回傳值與共用 path 的差別？
- 為什麼最大深度能直接取 `max`，最小深度卻要處理單側空孩子？
- 能否畫出一棵只比較父子會誤判的 BST 反例？
- 能否解釋 DFS 的 `O(h)`、BFS 的 `O(w)`，以及輸出成本為何另算？
- 解錯時，問題是在辨識、函式契約、base case、狀態還原，還是數值範圍？

個人錯題與心得：待補充。練習後記錄「原本如何定義狀態、最小反例、修正後的 invariant」，不要只保留最終程式碼。

## 待複習項目

| 時間 | 練習 | 自我驗收 |
| --- | --- | --- |
| 1 天後 | Q104、Q112、Q102 | 不看模板完成 DFS 與 BFS，說明空樹與葉節點的差別 |
| 1 週後 | Q110、Q98、Q230 | 能回傳子樹摘要、傳遞祖先界限，並使用 inorder 提前停止 |
| 1 個月後 | Q105，再選 Q543 或 Q236 延伸 | 用索引範圍重建，或區分子樹內最佳答案與向上回傳資訊 |

- [ ] 能從題目要求判斷答案屬於節點、子樹、路徑或層。
- [ ] 能不依賴可變全域欄位完成基本模板。
- [ ] 能正確處理單側子樹、負數、重複值與整數極值。
- [ ] 能在需要共用路徑時維持進入與退出的對稱。
- [ ] 能以實際高度、寬度與輸出量推導複雜度。

## 一分鐘速查

- **辨識訊號**：子樹答案用 postorder；祖先資訊往下傳；分層用 BFS；BST 才有有序剪枝。
- **最重要的 invariant**：每次呼叫的參數與回傳值都有固定意義；共用 path 返回前必須還原。
- **固定骨架**：先處理空節點，再傳遞或合併狀態；BFS 先固定本層大小；inorder 左 → 根 → 右。
- **常見邊界**：空樹不是葉節點；根到葉必須走到葉；最小深度不走空孩子；BST 約束來自所有祖先。
- **複雜度**：每節點一次為 `O(n)`；DFS 工作空間 `O(h)`，BFS queue `O(w)`，列表與路徑輸出另算。
- **選擇規則**：需要子樹結果先做 postorder；需要逐層距離用 BFS；遇到偏斜深樹再評估迭代寫法。
