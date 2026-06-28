package Stack;

import java.util.Stack;

public class Q439 {
    /**
     * Given a string expression representing arbitrarily nested ternary expressions, evaluate the expression, and return the result of it.
     * You can always assume that the given expression is valid and only contains digits, '?', ':', 'T', and 'F' where 'T' is true and 'F' is false. All the numbers in the expression are one-digit numbers (i.e., in the range [0, 9]).
     * The conditional expressions group right-to-left (as usual in most languages), and the result of the expression will always evaluate to either a digit, 'T' or 'F'.
     * 
     * Iterate the expression from tail
     * When encounter a character before '?', calculate the right value and push back to stack
     * Finally, peek the final value inside the stack and return the result
     * 
     * @param expression
     * @return
     */
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            Character ch = expression.charAt(i);       
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char num1 = stack.pop();
                stack.pop();
                char num2 = stack.pop();
                if (ch == 'T') {
                    stack.push(num1);
                } else if (ch == 'F') {
                    stack.push(num2);
                }
            } else {
                stack.push(ch);
            }


        }
        return String.valueOf(stack.peek());
    }
}
