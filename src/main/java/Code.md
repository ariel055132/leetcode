# Code

## Matrix
1. Transpose Matrix
* Matrix flipped over its main diagonal.
* Switching the matrix's row and column indices
```java
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }

```