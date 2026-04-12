public class Q1582 {
    public int numSpecial(int[][] mat) {
        int result = 0;

        // Traverse the row
        for (int i = 0; i < mat.length; i++) {
            // Traverse the column
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                boolean isSpecial = true;
                for (int row = 0; row < mat.length; row++) {
                    if (row != i && mat[row][j] == 1) {
                        isSpecial = false;
                        break;
                    }
                }

                for (int col = 0; col < mat[0].length; col++) {
                    if (col != j && mat[i][col] == 1) {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial) {
                    result++;
                }
            }
        }

        return result;
    }
}
