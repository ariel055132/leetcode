package Stack;

public class Q678 {
    /**
     * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     *
     * The following rules define a valid string:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     *
     * Approach: track the range [minOpen, maxOpen] of possible counts of unmatched
     * opening parentheses among valid interpretations of each prefix.
     * These counts are consecutive, so keeping just the two bounds is sufficient.
     * Each '*' can act as ')', an empty string, or '(' to adjust the range.
     *
     * Time: O(n). Extra space: O(1).
     *
     * @param s a string containing only '(', ')' and '*'
     * @return true if some interpretation of the stars produces balanced parentheses
     */
    public boolean checkValidString(String s) {
        int maxOpen = 0; // Largest possible number of unmatched opening parentheses.
        int minOpen = 0; // Smallest possible number of unmatched opening parentheses.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else { // *
                // Treat '*' as ')' for the lower bound and '(' for the upper bound.
                // Treating it as empty gives a count within the range.
                minOpen--;
                maxOpen++;
            }

            // Even the maximum count is negative: this ')' has no possible match.
            if (maxOpen < 0) {
                return false;
            }

            // Discard negative counts: a valid prefix cannot have unmatched ')'.
            // A later '(' cannot repair an earlier unmatched ')', so clamp negative values to zero.
            minOpen = Math.max(minOpen, 0);
        }
        // Zero is achievable if at least one interpretation has no unmatched '(' left.
        return minOpen == 0;
    }
}
