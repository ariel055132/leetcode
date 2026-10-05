package Stack;

import java.util.Stack;

public class Q856 {
    /**
     * Given a balanced parentheses string s, return the score of the string.
     *
     * The score of a balanced parentheses string is based on the following rule:
     * 1. "()" has score 1.
     * 2. AB has score A + B, where A and B are balanced parentheses strings.
     * 3. (A) has score 2 * A, where A is a balanced parentheses string.
     *
     * Approach:
     * Use a stack where each entry stores the accumulated score at one nesting level
     *
     * 1. Initialize the stack with zero for the outermost total.
     * 2. For each (, push 0 to start a new nesting level.
     * 3. For each ):
     *      Pop the interior subtotal.
     *      Compute the completed group's score: Math.max(1, 2 * inner)
     *      Pop the parent subtotal and push parent + groupScore
     * 4. Return the outermost total
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stk.push(0);
            } else {
                int currentEle = stk.pop();
                int groupScore = Math.max(1, 2* currentEle);
                int parent = stk.pop();
                stk.push(parent + groupScore);
            }
        }
        return stk.pop();
    }
}
