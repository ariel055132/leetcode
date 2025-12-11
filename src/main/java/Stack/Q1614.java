package Stack;

import java.util.Stack;

public class Q1614 {
    /**
     * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
     *
     * Approach: Use a stack to track the current nesting depth of valid parentheses.
     * Push to stack when encountering an opening parenthesis '('
     * Pop from stack when encountering a closing parenthesis ')' (if stack is not empty)
     * Track the maximum stack size to determine the maximum nesting depth.
     *
     * @param s String
     * @return result int (maximum nesting depth)
     */
    public int maxDepth(String s) {
        int result = 0;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                // No need to check for '(' before pop out as s is guaranteed as valid
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }
            result = Math.max(result, stk.size());
        }

        return result;
    }
}
