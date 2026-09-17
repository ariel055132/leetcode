public class Q311 {
    /**
     * Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
     * Just simulate as the question.
     * 
     * @param mat1
     * @param mat2
     * @return
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int resultRow = mat1.length;
        int resultCol = mat2[0].length;
        int[][] result = new int[resultRow][resultCol];

        for (int rowIndex = 0; rowIndex < resultRow; rowIndex++) {
            for (int elementIndex = 0; elementIndex < mat1[0].length; elementIndex++) {
                if (mat1[rowIndex][elementIndex] != 0) {
                    for (int colIndex = 0; colIndex < resultCol; colIndex++) {
                        result[rowIndex][colIndex] += mat1[rowIndex][elementIndex] * mat2[elementIndex][colIndex];
                    }
                }
            }
        }

        return result;
    }
}
