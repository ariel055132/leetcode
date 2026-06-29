public class Q1967 {
    /**
     * Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.
     * A substring is a contiguous sequence of characters within a string.
     * 
     * You can always check whether string a is a substring in b with lastIndexOf
     * if b.lastIndexOf(a) != -1, that means a is a substring in b
     * Otherwise, a is not a substring in b
     * 
     * @param patterns String[]
     * @param word String
     * @return
     */
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String pattern : patterns) {
            if (word.lastIndexOf(pattern) != -1) {
                result++;
            }
        }
        return result;
    }
}
