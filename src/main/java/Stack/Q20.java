package Stack;

import java.util.Stack;

public class Q20 {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     *
     * Match each closing bracket with the most recent unmatched opening bracket (LIFO).
     * For example, "([])" pushes '(' and '[', then pops '[' for ']' and '(' for ')'.
     *
     * Time: O(n). Space: O(n) for the stack and the array created by toCharArray().
     *
     * @param s a string containing only parentheses, square brackets, and curly braces
     * @return true if every bracket is matched in the correct order
     */
    public boolean isValid(String s) {
        // Store unmatched opening brackets, with the most recent one on top.
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                // add() appends at the top of this stack, just like push().
                stack.add(ch);
            } else {
                // A closing bracket must match the opening bracket at the top.
                // && skips checks for other closing types; || avoids popping an empty stack.
                if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                } else if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                } else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                }
            }
        }
        // Any remaining opening bracket is unmatched, so the string is invalid.
        return stack.isEmpty();
    }

}
