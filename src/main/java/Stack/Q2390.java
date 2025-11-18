package Stack;

import java.util.Stack;

public class Q2390 {
    /**
     * 1. Loop through the string character by character
     * 2. Add each character to a stack data structure
     * 3. If a star (*) is found, remove the top element from the stack
     *
     * @param s
     * @return
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
