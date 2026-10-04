package Stack;

import java.util.Stack;

public class Q32 {
    /**
     * Given a string containing just the characters '(' and ')'
     * Return the length of the longest valid (well-formed) parentheses substring
     *
     * Brute Force Approach:
     * 1. Try every substring.
     * 2. Check validity of substring using a stack.
     * 3. Record the maximum length
     *
     * @param s
     * @return
     */
    public int longValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // substring(i, j) excludes index j, therefore j must reach the string's length -> j <= s.length()
            for (int j = i + 1; j <= s.length(); j++) {
                if (isValid(s.substring(i, j))) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    /**
     * Check valid parentheses
     *
     * @param substring
     * @return
     */
    private boolean isValid(String substring) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '(') {
                stack.add('(');
            } else if (substring.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
