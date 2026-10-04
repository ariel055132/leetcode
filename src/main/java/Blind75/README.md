# Blind 75 題單與 Java 解法

整理日期：2026-10-04。文字使用繁體中文，程式碼使用 Java 17。

目前本目錄有 **15 個 Java 題目檔案**：12 題有實質解法、2 題有明確錯誤、1 題只有骨架。其餘 **60 題尚未在本目錄建立 Java 題檔**；這份筆記已提供全部 **75 題**的題意摘要、解題思路、範例、Java 實作、複雜度與易錯點。「已有檔案」不等於已通過所有測試，也不表示其他主題目錄沒有同題練習。

## 題單來源與版本

題單依 [Blind 原始貼文](https://www.teamblind.com/post/New-Year-Gift---Curated-List-of-Top-75-LeetCode-Questions-to-Save-Your-Time-OaM1orEU) 整理，個別題名與題意優先核對 LeetCode 官方頁面；每題筆記都附官方連結，解說與 Java 程式碼為本次整理。

- 原文的「Combination Sum」連結實際指向 **Q377 Combination Sum IV**，本筆記依該連結收錄。
- **Q23 Merge k Sorted Lists** 在原文的 Linked List 與 Heap 都出現，這裡只計一次，收在鏈結串列篇。
- **Q1143 Longest Common Subsequence** 已列於原文文字，這裡補上其官方題目連結。
- Q269、Q261、Q323、Q252、Q253、Q271 的官方頁面本次顯示 Premium 限制，未能讀取完整題面；各節明列採用的常見題意與方法介面，沒有把付費正文當作已取得的資料。

## 閱讀入口

每題的完整筆記可從下方題名直接跳入。分類沿用原始題單；實際解法可以跨 Pattern，例如 Jump Game 採貪心，Top K Frequent Elements 採頻率桶。

| 分類筆記 | 題數 | 本目錄已有 Java 題檔 |
| --- | ---: | ---: |
| [Array](01-arrays.md) | 10 | 6 |
| [Binary](02-bits.md) | 5 | 0 |
| [Dynamic Programming](03-dp.md) | 11 | 0 |
| [Graph](04-graphs.md) | 8 | 0 |
| [Interval](05-intervals.md) | 5 | 0 |
| [Linked List](06-linked-lists.md) | 6 | 3 |
| [Matrix](07-matrices.md) | 4 | 0 |
| [String](08-strings.md) | 10 | 4 |
| [Tree / Trie](09-trees.md) | 14 | 1 |
| [Heap](10-heap.md) | 2 | 1 |
| **合計** | **75** | **15** |

## 目前已有的 15 題：原程式採用什麼解法

下表依實際 Java 檔案整理。n、m 表示輸入大小，U 是不同值數，K 是輸出組合數；空間另外註明排序、字串複製與輸出成本。

| 題目／原檔案 | 目前實作 | 複雜度 | 狀態與閱讀重點 |
| --- | --- | --- | --- |
| [Q1](Q1.java) | 暴力雙迴圈；另有 `twoSumHashMap` 先查補數再加入 | 暴力 `O(n²)` / `O(1)`；Map 平均 `O(n)` / `O(n)` | 已有實作 |
| [Q11](Q11.java) | 相向指標，每次排除較矮的一端 | `O(n)` / `O(1)` | 已有實作 |
| [Q15](Q15.java) | 排序，固定一個值，再用雙指標；以 HashSet 去重 | `O(n²)`；集合 `O(K)`，另計排序空間 | 已有實作；會排序輸入 |
| [Q20](Q20.java) | Stack 檢查括號配對 | `O(n)` / `O(n)` | 已有實作 |
| [Q21](Q21.java) | 先選頭節點，再合併兩串列，最後接上剩餘尾段 | `O(m+n)` / `O(1)` | 已有實作；重接輸入節點 |
| [Q121](Q121.java) | left 記錄目前最低買價，right 掃描賣價 | `O(n)` / `O(1)` | 已有實作 |
| [Q125](Q125.java) | 先轉小寫，再跳過非英數字元比較兩端 | `O(n)` / `O(n)`（新字串） | 已有實作；筆記提供常數額外空間版 |
| [Q141](Q141.java) | 意圖使用 Floyd 快慢指標 | 預期 `O(n)` / `O(1)` | **需修正**：空串列與 next 存取 |
| [Q206](Q206.java) | 迭代保存 next、反轉連結、更新 prev | `O(n)` / `O(1)` | 已有實作 |
| [Q217](Q217.java) | HashSet 插入失敗就代表重複 | 平均 `O(n)` / `O(n)` | 已有實作 |
| [Q238](Q238.java) | 非零元素總乘積，再用除法排除自己 | `O(n)` / `O(1)`（不含輸出） | **需修正**：違反禁用除法，零值答案錯誤 |
| [Q242](Q242.java) | 字頻 HashMap；另有排序字元陣列版本 | 計數平均 `O(n)`、排序 `O(n log n)`；此 Java 寫法暫存字元陣列 `O(n)` | 已有實作 |
| [Q347](Q347.java) | HashMap 計頻率，大小 k 的 Min Heap 保留最高頻值 | 平均 `O(n+U log(k+1))` / `O(U+k)` | 已有實作；筆記另提供桶解法 |
| [Q424](Q424.java) | 僅初始化 result=0 並回傳 | 尚無有效解法 | **只有骨架** |
| [Q572](Q572.java) | 逐節點嘗試，再遞迴比對整棵子樹 | 最壞 `O(nm)` / `O(hRoot+hSub)` | 已有實作 |

### 已確認的待修項目

這些是原檔案的現況；分類筆記已提供相對應的完整解法。

| 項目 | 實際問題與重現 | 對應筆記 |
| --- | --- | --- |
| [Q141.java](Q141.java) | 空串列回傳 true；單節點無環串列會因存取 `fast.next.next` 觸發 NullPointerException。應先檢查 `fast.next != null`。 | [Floyd 正確版本](06-linked-lists.md#q141) |
| [Q238.java](Q238.java) | 使用題目禁止的除法，且 `zeroCnt` 未參與答案。輸入 `[-1,1,0,-3,3]` 實際回傳 `[-9,9,0,-3,3]`，正確應為 `[0,0,9,0,0]`。 | [前綴／後綴乘積](01-arrays.md#q238) |
| [Q424.java](Q424.java) | 固定回傳 0，例如 `ABAB, k=2` 正確答案應為 4。 | [完整 Sliding Window](08-strings.md#q424) |
| [Q238_test.java](../../../test/java/Blind75/Q238_test.java) | 第二個案例的輸入是 `[-1,-1,0,-3,3]`，非零乘積為 -9，因此正確預期為 `[0,0,-9,0,0]`；目前測試卻寫成 +9。 | 修正輸入或預期值後再驗證原程式 |

## 完整 75 題索引

「筆記補齊」表示本目錄尚無該題 Java 題檔，但連結內已有完整 Java 解法。題名連結導向本地解說，官方題目連結位於各節。

### Array（10 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q1. Two Sum](01-arrays.md#q1) | HashMap 補數查詢 | [Q1.java](Q1.java) |
| [Q121. Best Time to Buy and Sell Stock](01-arrays.md#q121) | 單次掃描最低買價 | [Q121.java](Q121.java) |
| [Q217. Contains Duplicate](01-arrays.md#q217) | HashSet 去重 | [Q217.java](Q217.java) |
| [Q238. Product of Array Except Self](01-arrays.md#q238) | 前綴／後綴乘積 | [Q238.java](Q238.java)：需修正 |
| [Q53. Maximum Subarray](01-arrays.md#q53) | Kadane | 筆記補齊 |
| [Q152. Maximum Product Subarray](01-arrays.md#q152) | 最大／最小結尾乘積 | 筆記補齊 |
| [Q153. Find Minimum in Rotated Sorted Array](01-arrays.md#q153) | 旋轉陣列二分搜尋 | 筆記補齊 |
| [Q33. Search in Rotated Sorted Array](01-arrays.md#q33) | 辨認有序半邊 | 筆記補齊 |
| [Q15. 3Sum](01-arrays.md#q15) | 排序＋雙指標去重 | [Q15.java](Q15.java) |
| [Q11. Container With Most Water](01-arrays.md#q11) | 移動較短端點 | [Q11.java](Q11.java) |

### Binary（5 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q371. Sum of Two Integers](02-bits.md#q371) | XOR 與進位 | 筆記補齊 |
| [Q191. Number of 1 Bits](02-bits.md#q191) | 移除最低位的 1 | 筆記補齊 |
| [Q338. Counting Bits](02-bits.md#q338) | 位元 DP | 筆記補齊 |
| [Q268. Missing Number](02-bits.md#q268) | 索引與值 XOR 抵消 | 筆記補齊 |
| [Q190. Reverse Bits](02-bits.md#q190) | 固定 32 次取位元 | 筆記補齊 |

### Dynamic Programming（11 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q70. Climbing Stairs](03-dp.md#q70) | 滾動 Fibonacci DP | 筆記補齊 |
| [Q322. Coin Change](03-dp.md#q322) | 最少硬幣 DP | 筆記補齊 |
| [Q300. Longest Increasing Subsequence](03-dp.md#q300) | 最小尾值＋二分搜尋 | 筆記補齊 |
| [Q1143. Longest Common Subsequence](03-dp.md#q1143) | 一列 LCS DP | 筆記補齊 |
| [Q139. Word Break](03-dp.md#q139) | 可達前綴 DP | 筆記補齊 |
| [Q377. Combination Sum IV](03-dp.md#q377) | 有序序列計數 DP | 筆記補齊 |
| [Q198. House Robber](03-dp.md#q198) | 選或不選的滾動 DP | 筆記補齊 |
| [Q213. House Robber II](03-dp.md#q213) | 排除首／尾的兩次 DP | 筆記補齊 |
| [Q91. Decode Ways](03-dp.md#q91) | 單碼／雙碼 DP | 筆記補齊 |
| [Q62. Unique Paths](03-dp.md#q62) | 一列網格 DP | 筆記補齊 |
| [Q55. Jump Game](03-dp.md#q55) | 貪心維護最遠可達位置 | 筆記補齊 |

### Graph（8 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q133. Clone Graph](04-graphs.md#q133) | BFS＋節點複製映射 | 筆記補齊 |
| [Q207. Course Schedule](04-graphs.md#q207) | Kahn 拓撲排序 | 筆記補齊 |
| [Q417. Pacific Atlantic Water Flow](04-graphs.md#q417) | 從海岸反向多源 BFS | 筆記補齊 |
| [Q200. Number of Islands](04-graphs.md#q200) | Flood Fill / BFS | 筆記補齊 |
| [Q128. Longest Consecutive Sequence](04-graphs.md#q128) | HashSet 只從連續段起點延伸 | 筆記補齊 |
| [Q269. Alien Dictionary](04-graphs.md#q269) · Premium | 字元偏序＋拓撲排序 | 筆記補齊 |
| [Q261. Graph Valid Tree](04-graphs.md#q261) · Premium | 邊數＋Union-Find | 筆記補齊 |
| [Q323. Number of Connected Components in an Undirected Graph](04-graphs.md#q323) · Premium | Union-Find 計連通塊 | 筆記補齊 |

### Interval（5 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q57. Insert Interval](05-intervals.md#q57) | 左段／重疊段／右段 | 筆記補齊 |
| [Q56. Merge Intervals](05-intervals.md#q56) | 按起點排序後合併 | 筆記補齊 |
| [Q435. Non-overlapping Intervals](05-intervals.md#q435) | 最早結束時間貪心 | 筆記補齊 |
| [Q252. Meeting Rooms](05-intervals.md#q252) · Premium | 排序後檢查相鄰衝突 | 筆記補齊 |
| [Q253. Meeting Rooms II](05-intervals.md#q253) · Premium | Min Heap 計同時需求 | 筆記補齊 |

### Linked List（6 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q206. Reverse Linked List](06-linked-lists.md#q206) | 迭代反轉 next | [Q206.java](Q206.java) |
| [Q141. Linked List Cycle](06-linked-lists.md#q141) | Floyd 快慢指標 | [Q141.java](Q141.java)：需修正 |
| [Q21. Merge Two Sorted Lists](06-linked-lists.md#q21) | Dummy＋雙串列合併 | [Q21.java](Q21.java) |
| [Q23. Merge k Sorted Lists](06-linked-lists.md#q23) | Min Heap 多路合併 | 筆記補齊 |
| [Q19. Remove Nth Node From End of List](06-linked-lists.md#q19) | 固定間距雙指標 | 筆記補齊 |
| [Q143. Reorder List](06-linked-lists.md#q143) | 找中點＋反轉後半＋交錯合併 | 筆記補齊 |

### Matrix（4 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q73. Set Matrix Zeroes](07-matrices.md#q73) | 第一列／欄作標記 | 筆記補齊 |
| [Q54. Spiral Matrix](07-matrices.md#q54) | 四邊界收縮 | 筆記補齊 |
| [Q48. Rotate Image](07-matrices.md#q48) | 轉置＋反轉每列 | 筆記補齊 |
| [Q79. Word Search](07-matrices.md#q79) | DFS 回溯 | 筆記補齊 |

### String（10 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q3. Longest Substring Without Repeating Characters](08-strings.md#q3) | 最後出現位置＋滑動視窗 | 筆記補齊 |
| [Q424. Longest Repeating Character Replacement](08-strings.md#q424) | 視窗長度減最高字頻 | [Q424.java](Q424.java)：只有骨架 |
| [Q76. Minimum Window Substring](08-strings.md#q76) | 缺少字頻＋最短合法視窗 | 筆記補齊 |
| [Q242. Valid Anagram](08-strings.md#q242) | 26 格字頻抵消 | [Q242.java](Q242.java) |
| [Q49. Group Anagrams](08-strings.md#q49) | 排序 key 分組 | 筆記補齊 |
| [Q20. Valid Parentheses](08-strings.md#q20) | Stack 保存期待的右括號 | [Q20.java](Q20.java) |
| [Q125. Valid Palindrome](08-strings.md#q125) | 相向字元比較 | [Q125.java](Q125.java) |
| [Q5. Longest Palindromic Substring](08-strings.md#q5) | 中心擴展找最長 | 筆記補齊 |
| [Q647. Palindromic Substrings](08-strings.md#q647) | 中心擴展計數 | 筆記補齊 |
| [Q271. Encode and Decode Strings](08-strings.md#q271) · Premium | 長度標頭編解碼 | 筆記補齊 |

### Tree / Trie（14 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q104. Maximum Depth of Binary Tree](09-trees.md#q104) | BFS 計層數 | 筆記補齊 |
| [Q100. Same Tree](09-trees.md#q100) | 遞迴比對結構和值 | 筆記補齊 |
| [Q226. Invert Binary Tree](09-trees.md#q226) | 遞迴交換左右子樹 | 筆記補齊 |
| [Q124. Binary Tree Maximum Path Sum](09-trees.md#q124) | 迭代後序＋單邊貢獻 | 筆記補齊 |
| [Q102. Binary Tree Level Order Traversal](09-trees.md#q102) | BFS 分層 | 筆記補齊 |
| [Q297. Serialize and Deserialize Binary Tree](09-trees.md#q297) | 含空節點標記的 BFS codec | 筆記補齊 |
| [Q572. Subtree of Another Tree](09-trees.md#q572) | 枚舉子樹根＋Same Tree | [Q572.java](Q572.java) |
| [Q105. Construct Binary Tree from Preorder and Inorder Traversal](09-trees.md#q105) | Preorder＋Inorder＋Stack | 筆記補齊 |
| [Q98. Validate Binary Search Tree](09-trees.md#q98) | 中序嚴格遞增 | 筆記補齊 |
| [Q230. Kth Smallest Element in a BST](09-trees.md#q230) | 中序取第 k 個 | 筆記補齊 |
| [Q235. Lowest Common Ancestor of a Binary Search Tree](09-trees.md#q235) | 利用 BST 尋找分岔點 | 筆記補齊 |
| [Q208. Implement Trie (Prefix Tree)](09-trees.md#q208) | Trie | 筆記補齊 |
| [Q211. Design Add and Search Words Data Structure](09-trees.md#q211) | Trie＋萬用字元分支 | 筆記補齊 |
| [Q212. Word Search II](09-trees.md#q212) | Trie 前綴剪枝＋DFS 回溯 | 筆記補齊 |

### Heap（2 題）

| 題目與解法連結 | 主要方法 | 本目錄 Java 現況 |
| --- | --- | --- |
| [Q347. Top K Frequent Elements](10-heap.md#q347) | 頻率桶（對照既有 Min Heap） | [Q347.java](Q347.java) |
| [Q295. Find Median from Data Stream](10-heap.md#q295) | Max Heap＋Min Heap | 筆記補齊 |

## 程式碼使用方式

每個 Java 區塊是獨立題目的類別。一般題使用 `class Solution`；設計題使用 `Codec`、`Trie`、`WordDictionary` 或 `MedianFinder`。不同題目的同名類別應分開編譯。

使用集合的區塊需要以下 import；本地編譯請放在檔案開頭：

```java
import java.util.*;
```

LeetCode 會為相關題目提供節點型別。本地可沿用 [ListNode](../LinkedList/ListNode.java)、[TreeNode](../Tree/TreeNode.java)，或使用以下最小定義；Q133 另外需要帶鄰居串列的 Node：

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Node {
    int val;
    List<Node> neighbors = new ArrayList<>();
    Node(int val) { this.val = val; }
}
```

若沿用 repo 型別，請加入 `import LinkedList.ListNode;` 與 `import Tree.TreeNode;`，而不是再次宣告同名型別。

- 複雜度中的 HashMap／HashSet 常數時間為平均假設；遞迴、排序、副本與輸出成本依各節標示。
- 程式碼依各題輸入契約撰寫。修改矩陣、重接串列或反轉樹的題目會改動輸入；回溯搜尋會在返回前復原棋盤。
- 樹的遞迴空間以高度 h 計算，鏈狀樹的 h 可達 n；Q104、Q124、Q297、Q105、Q98、Q230 等版本使用 queue／stack 管理走訪。
- Q377、Q91 的計數使用非負 DP：每一步將加總截到 int 最大值。因為 `min(M,a+b)=min(M,min(M,a)+min(M,b))`，截值後仍精確代表 `min(M,真實計數)`；題目保證最終答案可放入 int，因此不影響回傳值。

## 本次驗證

- 從 Markdown 抽出 **75 份**解法，分別補上共通 import 與節點型別，以 `javac --release 17 -Xlint:all -Werror` 編譯，全部通過且無警告。
- 每題執行範例或基本案例，以及重要邊界；共通過 **3,607 次斷言**，其中包含 Q15、Q238、Q424 各 100 組固定種子的隨機小輸入，與暴力答案比對。
- 額外檢查了 Q124 的 30,000 節點鏈狀樹、Q105 的 3,000 節點鏈狀樹、codec 往返還原、重複值、空輸入、零與負數、區間相接、圖中的環與非法字典前綴。
- 驗證對象是本文的 Java 解法，並另以最小案例重現上方三個原檔案問題；未執行 LeetCode 線上提交或全 repo 測試。

