public class Q867 {
    /**
     * Given a 2D integer array matrix, return the transpose of matrix.
     * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
     * 
     * Just simulation with the question
     * row, column -> column, row
     * 
     * @param matrix
     * @return
     */
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
}
