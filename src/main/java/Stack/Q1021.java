package Stack;

import java.util.Stack;

public class Q1021 {
    /**
     * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
     * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
     * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
     *
     * The stack size represents the current nesting depth. Each unmatched ( contributes one level.
     * An opening ( encountered at depth 0 starts an outermost pair, so skip it.
     * A closing ) that brings the depth back to 0 ends an outermost pair, so skip it.
     * Keep every other parenthesis
     *
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            /**
             * For each (:
             * If the stack is already nonempty, append it: inside an existing pair
             * Push it onto the stack, including when it was skipped
             */
            if (s.charAt(i) == '(') {
                if (stk.size() > 0) {
                    sb.append(s.charAt(i));
                }
                stk.push(s.charAt(i));
            } else { // meet )
                /**
                 * For each ):
                 * Pop its matching (
                 * If the stack is still non-empty, append it: remain inside another pair
                 */
                stk.pop();
                if (stk.size() > 0) {
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
