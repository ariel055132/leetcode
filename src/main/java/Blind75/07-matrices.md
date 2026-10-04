# Matrix：矩陣與回溯

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 見總覽。

<a id="q73"></a>
## Q73. Set Matrix Zeroes

[LeetCode 題目](https://leetcode.com/problems/set-matrix-zeroes/)

- **題意**：原矩陣某格為 0，就把它所在的整列、整欄設為 0，要求原地修改。
- **解法**：用第一列、第一欄當標記；另外保存它們原本是否含零，避免標記資料與原始資料混淆。先標記，再清除內部，最後處理第一列與第一欄。
- **範例**：[[1,1,1],[1,0,1],[1,1,1]]：標記第 1 列與第 1 欄後，清成 [[1,0,1],[0,0,0],[1,0,1]]。
- **複雜度**：時間 O(mn)，額外空間 O(1)。
- **注意**：不能遇到 0 就立即清整列欄，否則新產生的 0 會誤導後續判斷。

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstColumn = false;
        for (int c = 0; c < n; c++) if (matrix[0][c] == 0) firstRow = true;
        for (int r = 0; r < m; r++) if (matrix[r][0] == 0) firstColumn = true;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) { matrix[r][0] = 0; matrix[0][c] = 0; }
            }
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) matrix[r][c] = 0;
            }
        }
        if (firstRow) Arrays.fill(matrix[0], 0);
        if (firstColumn) for (int r = 0; r < m; r++) matrix[r][0] = 0;
    }
}
```

<a id="q54"></a>
## Q54. Spiral Matrix

[LeetCode 題目](https://leetcode.com/problems/spiral-matrix/)

- **題意**：以順時針螺旋順序輸出矩陣所有元素。
- **解法**：四個邊界描述未走訪的矩形；依序走上、右、下、左，每走完一邊就縮小對應邊界。
- **範例**：[[1,2,3],[4,5,6],[7,8,9]] → [1,2,3,6,9,8,7,4,5]。
- **複雜度**：時間 O(mn)，輸出 O(mn)，其餘額外空間 O(1)。
- **注意**：下邊與左邊走訪前要重新檢查邊界，避免單列或單欄被輸出兩次。

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return answer;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) answer.add(matrix[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) answer.add(matrix[r][right]);
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) answer.add(matrix[bottom][c]);
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) answer.add(matrix[r][left]);
                left++;
            }
        }
        return answer;
    }
}
```

<a id="q48"></a>
## Q48. Rotate Image

[LeetCode 題目](https://leetcode.com/problems/rotate-image/)

- **題意**：將 n×n 正方形矩陣原地順時針旋轉 90 度。
- **解法**：先沿主對角線轉置，再左右反轉每列；座標 (r,c) 最終會到 (c,n-1-r)。
- **範例**：[[1,2],[3,4]]：轉置為 [[1,3],[2,4]]，各列反轉後為 [[3,1],[4,2]]。
- **複雜度**：時間 O(n²)，額外空間 O(1)。
- **注意**：轉置只交換對角線一側，否則交換兩次就回到原狀；本題一定是正方形。

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        for (int[] row : matrix) {
            for (int left = 0, right = n - 1; left < right; left++, right--) {
                int temp = row[left]; row[left] = row[right]; row[right] = temp;
            }
        }
    }
}
```

<a id="q79"></a>
## Q79. Word Search

[LeetCode 題目](https://leetcode.com/problems/word-search/)

- **題意**：判斷單字是否能沿四方向相鄰格子拼出，同一路徑不能重複使用格子。
- **解法**：從每格 DFS 嘗試；匹配目前字元後暫時標記已用，探索下一字元，返回前復原。visited 屬於目前路徑，不能永久保留。
- **範例**：[[A,B,C,E],[S,F,C,S],[A,D,E,E]] 中 ABCCED 沿相鄰格可找到，ABCB 會重用 B，因此找不到。
- **複雜度**：保守上界 O(mn×4^L)，額外遞迴空間 O(L)，L 為單字長度。
- **注意**：不論成功或失敗都復原棋盤；字母輸入不會包含標記字元 #。

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        if (word.length() > board.length * board[0].length) return false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (search(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int r, int c, int index) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        char saved = board[r][c];
        board[r][c] = '#';
        boolean found = search(board, word, r - 1, c, index + 1)
                || search(board, word, r + 1, c, index + 1)
                || search(board, word, r, c - 1, index + 1)
                || search(board, word, r, c + 1, index + 1);
        board[r][c] = saved;
        return found;
    }
}
```

