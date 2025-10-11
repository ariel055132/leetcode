public class Q766 {
    /**
     * Given an m * n matrix, return true if the matrix is Toeplitz. Otherwise, return false
     * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements
     *
     * matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]] -> true (Topelitz)
     * 1 2 3 4
     * 5 1 2 3
     * 9 5 1 2
     *
     * 9
     * 1 1 1
     * 2 2 2
     * 3 3
     * 4
     * @param matrix int[][] m * n matrix
     * @return matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
