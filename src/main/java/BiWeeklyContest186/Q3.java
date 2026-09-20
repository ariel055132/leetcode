package BiWeeklyContest186;

public class Q3 {
    /**
     * You are given two binary strings s1 and s2 of the same length n.
     * You can perform the following operations on s1 any number of times, in any order:
     * Choose an index i such that s1[i] == '0', and change it to '1'.
     * Choose an index i such that 0 <= i < n - 1, and both s1[i] and s1[i + 1] are '1'. Change both characters to '0'.
     * Return the minimum number of operations required to make s1 equal to s2. If it is impossible, return -1.
     * 
     * @param s1
     * @param s2
     * @return
     */
    public int minOperations(String s1, String s2) {
        // Situation: String length == 1
        if (s1.length() == 1) {
            if (s1.equals(s2)) {
                return 0;
            }
            return s1.charAt(0) == '0' ? 1 : -1;
        }
        
        // Other situation
        int onesS1 = 0;
        int onesS2 = 0;
        int operation = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                onesS1++;
            }
            if (s2.charAt(i) == '1') {
                onesS2++;
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            boolean required =
                s1.charAt(i) == '1' && s2.charAt(i) == '0';

            if (!required) {
                continue;
            }

            operation++; // // One double-clear is needed for this required position.

            // Pair two adjacent required positions together.
            // Share it with the next position if that position also requires clearing.
            if (i + 1 < s1.length()
                    && s1.charAt(i + 1) == '1'
                    && s2.charAt(i + 1) == '0') {
                i++;
            }
        }

        return onesS2 - onesS1 + 3 * operation;
    }
}
