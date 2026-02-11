package Stack;

import java.util.Stack;

public class Q1190 {
    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(result.length());
            } else if (s.charAt(i) == ')') {
                // Obtain the last element of stack (length of the word)
                int len = stk.pop();
                // reverse the string
                reverse(result, len, result.length() - 1);
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start , sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}
