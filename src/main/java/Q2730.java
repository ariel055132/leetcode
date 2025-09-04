public class Q2730 {
    /**
     * Finding the longest sliding window where have at most one s[i] == s[i+1] pair
     *
     * @param s String
     * @return length of the longest window where have at most one s[i] == s[i+1] pair
     */
    public int longestSemiRepetitiveSubstring(String s) {
        int result = 0;
        int left = 0;
        int duplicatedPair = 0; // save the number of pairs where s[i] == s[i+1]
        for (int right = 1; right < s.length(); right++) {
            // Find s[i] == s[i+1] pair, duplicatedPair++
            if (s.charAt(right - 1) == s.charAt(right)) {
                duplicatedPair++;
            }
            // When duplicatedPair > 1, which means that the windows have more than one s[i] == s[i+1] pair
            if (duplicatedPair > 1) {
                break;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
