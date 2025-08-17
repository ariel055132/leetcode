package Stack;

import java.util.Stack;

/**
 * If it's invalid, return a valid string
 * Otherwise just return the original string.
 *
 * For example
 * 1. String s = '()', return '()'
 * 2. String s = ')',
 */
public class Q20_FollowUp {
    public String convertToValidBracketString(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                result += c;
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    result += '(';
                }
                result += c;
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    result += '[';
                }
                result += c;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    result += '{';
                }
                result += c;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                result += ')';
            } else if (stack.peek() == '[') {
                result += ']';
            } else if (stack.peek() == '{') {
                result += '}';
            } else if (stack.peek() == ')') {
                result += '(';
            } else if (stack.peek() == ']') {
                result += '[';
            } else if (stack.peek() == '}') {
                result += '{';
            }
            stack.pop();
        }
        return result;
    }
}
