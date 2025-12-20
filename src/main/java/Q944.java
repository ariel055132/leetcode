public class Q944 {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        // Traversal the column one by one, and find out the column that is not sorted lexicographically
        int row = strs.length;
        int col = strs[0].length(); // use 0 as it is ensured that string with of the same length
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
