package Stack;

import java.util.Stack;

public class Q856 {
    public int scoreOfParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        int result = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stk.push(ch);
            } else {
                result += Math.max(1, result * 2);
            }
        }
        return result;
    }
}
