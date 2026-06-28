public class Q1180 {
    /**
     * Given a string s, return the number of substrings that have only one distinct letter.
     * 
     * @param s
     * @return
     */
    public int countLetters(String s) {
        int ans = 0, repeat = 1;
        for (int i = 1; i < s.length(); ++i, ++repeat) {
            if (s.charAt(i) != s.charAt(i - 1)) { // previous char consectively occurs 'repeat' times.
                ans += repeat * (repeat + 1) / 2;
                repeat = 0;
            }
        }
        return ans + repeat * (repeat + 1) / 2;
    }

    /**
     * 
     * @param s
     * @return
     */
    public int countLetters2(String s) {
        int result = 1;
        int runningLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                runningLength++;
            } else {
                runningLength = 1;
            }
            result += runningLength;
        }
        return result;
    }
}
