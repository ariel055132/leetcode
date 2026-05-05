public class Q796 {
    /**
     * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
     * A shift on s consists of moving the leftmost character of s to the rightmost position.
     * 
     * Every rotation of s appears as a contiguous substring of s + s.
     * Therefore, the condition is: same length and goal is contained in s + s.
     * 
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        // Check the length of s abd goal. If not equal, return false.
        if (s.length() != goal.length()) return false;
        // Build s + s
        String newS = s + s;
        // Check whether the s + s contains goal, and return the result.
        if (newS.contains(goal)) return true;
        return false;
    }
}
