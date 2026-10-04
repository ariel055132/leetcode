# Tree / Trie：二元樹、BST 與字典樹

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，TreeNode 與共通 import 見總覽。h 表示樹高，w 表示最大層寬，S 表示插入 Trie 的總字元數。

<a id="q104"></a>
## Q104. Maximum Depth of Binary Tree

[LeetCode 題目](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

- **題意**：求二元樹由根到最深葉節點的節點數。
- **解法**：BFS 每完成一層就將深度加一；queue 保存下一層待處理節點。
- **範例**：[3,9,20,null,null,15,7]：三次整層處理後佇列清空，深度 3。
- **複雜度**：時間 O(n)，額外空間 O(w)，w 是最大層寬。
- **注意**：空樹深度為 0；每層先固定 size，避免把新加入的下一層混進本層。

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
```

<a id="q100"></a>
## Q100. Same Tree

[LeetCode 題目](https://leetcode.com/problems/same-tree/)

- **題意**：判斷兩棵樹的結構與對應節點值是否完全相同。
- **解法**：兩邊都空則相同，只有一邊空則不同；目前值相同後，左右子樹也必須分別相同。
- **範例**：[1,2,3] 與 [1,2,3] 為 true；[1,2] 與 [1,null,2] 值相同但結構不同，為 false。
- **複雜度**：時間 O(n+m) 的上界；遞迴空間 O(h1+h2) 的上界。
- **注意**：不能只比較走訪時的非空值序列，空節點位置也屬於結構。

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
```

<a id="q226"></a>
## Q226. Invert Binary Tree

[LeetCode 題目](https://leetcode.com/problems/invert-binary-tree/)

- **題意**：交換每個節點的左右子樹，原地鏡像整棵樹。
- **解法**：先鏡像原左子樹並保存結果，再鏡像原右子樹，將兩個結果交換接回。
- **範例**：[2,1,3] 交換根的兩個孩子後變成 [2,3,1]。
- **複雜度**：時間 O(n)，遞迴空間 O(h)。
- **注意**：會修改輸入樹；保存原左結果，避免覆寫後失去參照。

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
```

<a id="q124"></a>
## Q124. Binary Tree Maximum Path Sum

[LeetCode 題目](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

- **題意**：求非空簡單路徑的最大節點總和，起終點不一定是根或葉。
- **解法**：每個節點向父節點只能提供一條單邊貢獻；但更新答案時可把左右正貢獻都加進來。先收集父先於子的順序，再反向處理，確保先取得子樹答案。
- **範例**：[-10,9,20,null,null,15,7]：在節點 20 可形成 15→20→7，總和 42。
- **複雜度**：時間 O(n)，此迭代版使用 O(n) 額外空間保存順序與貢獻。
- **注意**：答案初始為最小整數，保留全負數時的非空最大值；迭代寫法也避免深樹的遞迴堆疊限制。

```java
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> order = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            order.add(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Map<TreeNode, Integer> gain = new IdentityHashMap<>();
        int best = Integer.MIN_VALUE;
        for (int i = order.size() - 1; i >= 0; i--) {
            TreeNode node = order.get(i);
            int left = Math.max(0, gain.getOrDefault(node.left, 0));
            int right = Math.max(0, gain.getOrDefault(node.right, 0));
            best = Math.max(best, node.val + left + right);
            gain.put(node, node.val + Math.max(left, right));
        }
        return best;
    }
}
```

<a id="q102"></a>
## Q102. Binary Tree Level Order Traversal

[LeetCode 題目](https://leetcode.com/problems/binary-tree-level-order-traversal/)

- **題意**：由上到下，每層由左到右輸出節點值。
- **解法**：BFS 每輪固定目前層的 queue 大小，取出該層並將孩子排到下一層。
- **範例**：[3,9,20,null,null,15,7] → [[3],[9,20],[15,7]]。
- **複雜度**：時間 O(n)，queue 額外空間 O(w)，輸出 O(n)。
- **注意**：ArrayDeque 不接受 null，只把非空孩子放入。

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            answer.add(level);
        }
        return answer;
    }
}
```

<a id="q297"></a>
## Q297. Serialize and Deserialize Binary Tree

[LeetCode 題目](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

- **題意**：把樹編成字串，再無損還原相同結構與值。
- **解法**：BFS 保存每個節點與空孩子標記 #。解碼時以同樣的順序，每次為一個父節點讀取兩個孩子。
- **範例**：[1,2,3,null,null,4,5] 編碼為 1,2,3,#,#,4,5,#,#,#,#,，解碼後結構不變。
- **複雜度**：時間與暫存 O(B)，B 是編碼字串長度；還原樹另需 O(n)。
- **注意**：serialize 的 LinkedList queue 刻意允許 null；deserialize 只放實際節點，可用 ArrayDeque。假設解碼輸入由此 codec 產生。

```java
class Codec {
    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                out.append("#,");
            } else {
                out.append(node.val).append(',');
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return out.toString();
    }
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        if (tokens[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            String left = tokens[index++], right = tokens[index++];
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left);
            }
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.add(node.right);
            }
        }
        return root;
    }
}
```

<a id="q572"></a>
## Q572. Subtree of Another Tree

[LeetCode 題目](https://leetcode.com/problems/subtree-of-another-tree/)

- **題意**：判斷 root 是否包含一棵結構與值都和 subRoot 相同的完整子樹。
- **解法**：枚舉 root 的每個節點當候選根，再以 Same Tree 邏輯比對整棵子樹。
- **範例**：root=[3,4,5,1,2]、subRoot=[4,1,2]：從值為 4 的節點開始完整匹配。
- **複雜度**：最壞時間 O(nm)，n、m 為兩樹節點數；遞迴空間上界 O(hRoot+hSub)。
- **注意**：既有版採相同雙層遞迴；不能只找相同根值，必須比對所有孩子與空位置。

```java
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        return same(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }
    private boolean same(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
    }
}
```

<a id="q105"></a>
## Q105. Construct Binary Tree from Preorder and Inorder Traversal

[LeetCode 題目](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

- **題意**：節點值互異，根據同一棵樹的 preorder 與 inorder 重建樹。
- **解法**：preorder 決定新節點順序；stack 保存尚未完成 inorder 的祖先。stack 頂端尚未等於下一個 inorder 值時，新節點接左邊；否則彈出已完成祖先，接到最後彈出者的右邊。
- **範例**：pre=[3,9,20,15,7]、in=[9,3,15,20,7]：先接 9 到 3 左側，完成 9 與 3 的 inorder 後，20 接到 3 右側。
- **複雜度**：時間 O(n)，stack O(h)，輸出樹 O(n)。
- **注意**：兩種走訪合法且值互異是前提；迭代寫法不需切片，也不依賴遞迴深度。

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode parent = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            if (parent.val != inorder[inIndex]) {
                parent.left = child;
            } else {
                while (!stack.isEmpty() && inIndex < inorder.length
                        && stack.peek().val == inorder[inIndex]) {
                    parent = stack.pop();
                    inIndex++;
                }
                parent.right = child;
            }
            stack.push(child);
        }
        return root;
    }
}
```

<a id="q98"></a>
## Q98. Validate Binary Search Tree

[LeetCode 題目](https://leetcode.com/problems/validate-binary-search-tree/)

- **題意**：判斷整棵二元樹是否滿足嚴格 BST 大小關係。
- **解法**：BST 的 inorder 必須嚴格遞增。迭代中序走訪，將每個值與前一個走訪值比較，就能同時檢查所有祖先限制。
- **範例**：[5,1,4,null,null,3,6] 的 inorder 含 5→3 的下降，回傳 false。
- **複雜度**：時間 O(n)，額外 stack 空間 O(h)。
- **注意**：重複值也非法；previous 使用 long 最小值，允許節點等於 Integer.MIN_VALUE。

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        long previous = Long.MIN_VALUE;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.val <= previous) return false;
            previous = current.val;
            current = current.right;
        }
        return true;
    }
}
```

<a id="q230"></a>
## Q230. Kth Smallest Element in a BST

[LeetCode 題目](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

- **題意**：回傳 BST 第 k 小的節點值，k 從 1 開始。
- **解法**：inorder 依小到大取出節點，取到第 k 個即可結束，不必保存全部值。
- **範例**：[3,1,4,null,2] 的 inorder 是 1、2、3、4，k=1 回傳 1。
- **複雜度**：時間 O(h+k)，額外空間 O(h)。
- **注意**：k 必須依「彈出並拜訪節點」減一，不能在向左走時減少；題目保證 k 有效。

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (--k == 0) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k is outside the tree");
    }
}
```

<a id="q235"></a>
## Q235. Lowest Common Ancestor of a Binary Search Tree

[LeetCode 題目](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

- **題意**：求 BST 中指定兩節點的最低共同祖先；兩節點保證存在且值互異。
- **解法**：兩值都小於目前值就往左，都大於就往右；第一次分開兩側或等於目前節點時，目前節點就是分岔點。
- **範例**：BST 根為 6，p=2、q=8 分居兩側，所以 LCA 是 6；p=2、q=4 則在節點 2 停下。
- **複雜度**：時間 O(h)，額外空間 O(1)。
- **注意**：只有 BST 才能用值決定方向；一般二元樹需另用子樹搜尋。

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val < current.val && q.val < current.val) current = current.left;
            else if (p.val > current.val && q.val > current.val) current = current.right;
            else return current;
        }
        return null;
    }
}
```

<a id="q208"></a>
## Q208. Implement Trie (Prefix Tree)

[LeetCode 題目](https://leetcode.com/problems/implement-trie-prefix-tree/)

- **題意**：實作小寫英文字母的 insert、完整單字 search 與 startsWith。
- **解法**：每條邊是一個字母，沿路徑走完代表前綴存在；另用 end 標記區分完整單字。
- **範例**：插入 apple 後，search(apple)=true、search(app)=false、startsWith(app)=true。
- **複雜度**：每次操作時間 O(L)，L 為輸入長度；儲存空間 O(S)，S 為所有插入字元數的上界，字母表固定 26。
- **注意**：前綴存在不代表它是已插入的完整單字。

```java
class Trie {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end;
    }
    private final TrieNode root = new TrieNode();
    public Trie() {}
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.end = true;
    }
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.end;
    }
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
    private TrieNode find(String text) {
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            node = node.children[text.charAt(i) - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

<a id="q211"></a>
## Q211. Design Add and Search Words Data Structure

[LeetCode 題目](https://leetcode.com/problems/design-add-and-search-words-data-structure/)

- **題意**：插入小寫英文單字，搜尋時 . 可以代表任一個字母。
- **解法**：Trie 保存單字；一般字母只走一條邊，遇到 . 就搜尋所有存在的孩子。走完模式後還必須到達完整單字的 end。
- **範例**：插入 bad、dad、mad 後，search(.ad)=true、search(b..)=true、search(pad)=false。
- **複雜度**：插入 O(L)；搜尋保守上界 O(L×26^d)，d 為萬用字元數；搜尋堆疊 O(L)，Trie 儲存 O(S)。
- **注意**：不能把含 . 的搜尋一律標成 O(L)，萬用字元會產生分支。

```java
class WordDictionary {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end;
    }
    private final TrieNode root = new TrieNode();
    public WordDictionary() {}
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.end = true;
    }
    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.end;
        char c = word.charAt(index);
        if (c != '.') return search(word, index + 1, node.children[c - 'a']);
        for (TrieNode child : node.children) {
            if (child != null && search(word, index + 1, child)) return true;
        }
        return false;
    }
}
```

<a id="q212"></a>
## Q212. Word Search II

[LeetCode 題目](https://leetcode.com/problems/word-search-ii/)

- **題意**：在字母棋盤中找出字典裡所有可沿四方向相鄰格子拼出的單字，每條路徑不可重用格子。
- **解法**：先建 Trie，DFS 棋盤時同步沿 Trie 走；不存在前綴就停止。找到完整單字後清除 word 標記，讓不同路徑不會重複輸出。
- **範例**：[[a,b],[c,d]] 與 [ab,ac,abcd]：可找到 ab、ac；abcd 的 b 與 c 不相鄰，找不到。
- **複雜度**：保守時間上界 O(S+mn×4^L)，S 是字典總字元數，L 是最長單字；額外空間 O(S+L)，輸出 O(K) 個字串參照。
- **注意**：字元皆為小寫英文字母。DFS 完成後復原棋盤；每次呼叫重新建立 Trie，避免殘留上次去重狀態。

```java
class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) return answer;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = word;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) search(board, r, c, root, answer);
        }
        return answer;
    }
    private void search(char[][] board, int r, int c, TrieNode parent, List<String> answer) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char saved = board[r][c];
        if (saved == '#') return;
        TrieNode node = parent.children[saved - 'a'];
        if (node == null) return;
        if (node.word != null) {
            answer.add(node.word);
            node.word = null;
        }
        board[r][c] = '#';
        search(board, r - 1, c, node, answer);
        search(board, r + 1, c, node, answer);
        search(board, r, c - 1, node, answer);
        search(board, r, c + 1, node, answer);
        board[r][c] = saved;
    }
}
```
