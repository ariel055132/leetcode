# Graph：圖、連通性與拓撲排序

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 與 Node 型別見總覽。α(n) 為反 Ackermann 函數。

<a id="q133"></a>
## Q133. Clone Graph

[LeetCode 題目](https://leetcode.com/problems/clone-graph/)

- **題意**：深拷貝由給定節點可到達的無向圖，保留鄰接關係。
- **解法**：BFS 配合「原節點→複製節點」映射。發現鄰居時先建立並記錄副本，再排入佇列，環就不會造成重複建立。
- **範例**：兩個互連節點 1↔2：先建立 1 的副本，處理鄰居建立 2，再連回既有的 1 副本。
- **複雜度**：時間 O(V+E)；映射與佇列 O(V)，輸出圖 O(V+E)。
- **注意**：映射用節點身分，不用 val；原節點與副本不可共用同一個 neighbors。

```java
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> copies = new IdentityHashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        copies.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node original = queue.remove();
            for (Node neighbor : original.neighbors) {
                if (!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                copies.get(original).neighbors.add(copies.get(neighbor));
            }
        }
        return copies.get(node);
    }
}
```

<a id="q207"></a>
## Q207. Course Schedule

[LeetCode 題目](https://leetcode.com/problems/course-schedule/)

- **題意**：課程有先修依賴，判斷是否能修完全部課程。
- **解法**：將 [course, prerequisite] 建成 prerequisite→course。Kahn 拓撲排序持續移除入度 0 的節點，能移除全部就沒有環。
- **範例**：2 門課、[[1,0]]：先修 0，再將 1 入度降為 0；若再有 [0,1] 就形成環。
- **複雜度**：時間 O(V+E)，額外空間 O(V+E)。
- **注意**：邊方向與入度必須一致；沒有任何先修關係的課程也要計入。

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.add(i);
        int completed = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            completed++;
            for (int next : graph.get(current)) {
                if (--indegree[next] == 0) queue.add(next);
            }
        }
        return completed == numCourses;
    }
}
```

<a id="q417"></a>
## Q417. Pacific Atlantic Water Flow

[LeetCode 題目](https://leetcode.com/problems/pacific-atlantic-water-flow/)

- **題意**：找出雨水能沿不升高的相鄰路徑流向兩個海洋的格子。
- **解法**：反向從兩側海岸各做一次多源 BFS，只往相同或更高的格子走；兩份可達集合的交集就是答案。
- **範例**：[[1]] 同時接觸兩個海洋，兩份 visited 都包含 (0,0)，答案 [[0,0]]。
- **複雜度**：時間 O(mn)，額外空間 O(mn)，另計輸出。
- **注意**：反向搜尋的不等式是 nextHeight>=currentHeight，不能沿用正向水流方向。

```java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) return answer;
        boolean[][] pacific = reach(heights, true);
        boolean[][] atlantic = reach(heights, false);
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) answer.add(List.of(r, c));
            }
        }
        return answer;
    }
    private boolean[][] reach(int[][] h, boolean pacific) {
        int m = h.length, n = h[0].length;
        boolean[][] seen = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) add(r, pacific ? 0 : n - 1, seen, queue);
        for (int c = 0; c < n; c++) add(pacific ? 0 : m - 1, c, seen, queue);
        int[] d = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            for (int k = 0; k < 4; k++) {
                int r = cell[0] + d[k], c = cell[1] + d[k + 1];
                if (r >= 0 && r < m && c >= 0 && c < n
                        && !seen[r][c] && h[r][c] >= h[cell[0]][cell[1]]) {
                    add(r, c, seen, queue);
                }
            }
        }
        return seen;
    }
    private void add(int r, int c, boolean[][] seen, Deque<int[]> queue) {
        if (!seen[r][c]) {
            seen[r][c] = true;
            queue.add(new int[] {r, c});
        }
    }
}
```

<a id="q200"></a>
## Q200. Number of Islands

[LeetCode 題目](https://leetcode.com/problems/number-of-islands/)

- **題意**：計算四方向相連的陸地區塊數。
- **解法**：掃描到尚未拜訪的 1 就開始新島，BFS 把整個連通塊標成 0。每格只會入隊一次。
- **範例**：[[1,1,0],[0,1,0],[0,0,1]]：左上區塊與右下單格分開，共 2 座島。
- **複雜度**：時間 O(mn)，佇列最壞 O(mn)。
- **注意**：此解法會修改 grid；需要保留原圖時改用 visited。入隊時就標記，避免重複入隊。

```java
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        int[] d = {-1, 0, 1, 0, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != '1') continue;
                count++;
                grid[r][c] = '0';
                queue.add(new int[] {r, c});
                while (!queue.isEmpty()) {
                    int[] cell = queue.remove();
                    for (int k = 0; k < 4; k++) {
                        int nr = cell[0] + d[k], nc = cell[1] + d[k + 1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                            grid[nr][nc] = '0';
                            queue.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
}
```

<a id="q128"></a>
## Q128. Longest Consecutive Sequence

[LeetCode 題目](https://leetcode.com/problems/longest-consecutive-sequence/)

- **題意**：忽略原始排列，求數值連續的最長序列長度。
- **解法**：先用 HashSet 去重；只有 x-1 不存在時，x 才是某段起點，從這裡往後延伸。每段只掃描一次。
- **範例**：[100,4,200,1,3,2]：只從 1 延伸到 4，得到長度 4。
- **複雜度**：平均時間 O(n)，額外空間 O(n)。
- **注意**：迭代 set 而非原陣列，避免重複起點造成重複掃描；本題值域讓 x±1 不會溢位。

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);
        int best = 0;
        for (int x : values) {
            if (values.contains(x - 1)) continue;
            int end = x;
            while (values.contains(end + 1)) end++;
            best = Math.max(best, end - x + 1);
        }
        return best;
    }
}
```

<a id="q269"></a>
## Q269. Alien Dictionary

[LeetCode 題目](https://leetcode.com/problems/alien-dictionary/)

- **題意**：Premium 題採常見題意：由已按外星字母順序排列的單字，回傳任一合法字母順序；矛盾時回傳空字串。
- **解法**：相鄰單字的第一個不同字元提供一條先後邊，再做拓撲排序。只看第一個差異，因為後續字元不影響這兩字的字典序。
- **範例**：[wrt,wrf,er,ett,rftt] 推出 t→f、w→e、r→t、e→r，得到 wertf。
- **複雜度**：時間 O(C+V+E)，空間 O(V+E)，C 為所有單字總長。
- **注意**：[abc,ab] 是非法前綴；重複邊只加一次入度；未出現在任何邊上的字元也須輸出。介面採 alienOrder(String[] words)。

```java
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, ignored -> new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1], b = words[i];
            int j = 0, limit = Math.min(a.length(), b.length());
            while (j < limit && a.charAt(j) == b.charAt(j)) j++;
            if (j == limit) {
                if (a.length() > b.length()) return "";
            } else {
                char from = a.charAt(j), to = b.charAt(j);
                if (graph.get(from).add(to)) indegree.put(to, indegree.get(to) + 1);
            }
        }
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) if (indegree.get(c) == 0) queue.add(c);
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.remove();
            order.append(c);
            for (char next : graph.get(c)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) queue.add(next);
            }
        }
        return order.length() == indegree.size() ? order.toString() : "";
    }
}
```

<a id="q261"></a>
## Q261. Graph Valid Tree

[LeetCode 題目](https://leetcode.com/problems/graph-valid-tree/)

- **題意**：Premium 題採常見題意：節點為 0..n-1 的無向圖，判斷是否連通且無環。
- **解法**：n 個節點的樹需要 n-1 條邊。邊數符合後，以 Union-Find 確保每條邊都連接不同連通塊；n-1 次成功合併後恰好剩一塊。
- **範例**：n=5、[[0,1],[0,2],[0,3],[1,4]]：四條邊皆成功合併，回傳 true。
- **複雜度**：時間 O(n+Eα(n))，額外空間 O(n)；使用路徑壓縮與按大小合併。
- **注意**：介面採 validTree(int n, int[][] edges)。n=0 視為不是樹；單節點無邊則為樹。

```java
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1) return false;
        int[] parent = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }
        for (int[] edge : edges) {
            int a = find(parent, edge[0]), b = find(parent, edge[1]);
            if (a == b) return false;
            if (size[a] < size[b]) { int temp = a; a = b; b = temp; }
            parent[b] = a;
            size[a] += size[b];
        }
        return true;
    }
    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
```

<a id="q323"></a>
## Q323. Number of Connected Components in an Undirected Graph

[LeetCode 題目](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)

- **題意**：Premium 題採常見題意：計算節點 0..n-1 的無向圖有幾個連通塊。
- **解法**：初始每個節點各自一塊。Union-Find 每次合併不同根時，連通塊數減一。
- **範例**：n=5、[[0,1],[1,2],[3,4]]：5→4→3→2，答案 2。
- **複雜度**：時間 O(n+Eα(n))，額外空間 O(n)。
- **注意**：孤立節點也算一塊；同一連通塊內的邊不可再減一次。介面採 countComponents(int n, int[][] edges)。

```java
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }
        int components = n;
        for (int[] edge : edges) {
            int a = find(parent, edge[0]), b = find(parent, edge[1]);
            if (a == b) continue;
            if (size[a] < size[b]) { int temp = a; a = b; b = temp; }
            parent[b] = a;
            size[a] += size[b];
            components--;
        }
        return components;
    }
    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
```
