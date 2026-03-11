public class Q1784 {
    /**
     * Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. 
     * Otherwise, return false.
     * 
     * Constraints:
     * 1 <= s.length <= 100
     * s[i] is either '0' or '1'
     * s[0] is 1
     * 
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        boolean result = true;
        // Start from index 1 since s[0] is guaranteed to be '1'
        for (int i = 1; i < s.length(); i++) {
            // When we encounter a '1', check if the previous character was '0'
            // This indicates a second segment of ones, so return false
            if (s.charAt(i) == '1') {
                if (s.charAt(i-1) == '0' && result) {
                    return false;
                }   
            }
        }
        return result;
    }
}