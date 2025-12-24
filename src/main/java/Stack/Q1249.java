package Stack;

import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        // Save the index of ( and )
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (currentChar == '(') {
                stk.push(i);
                sb.append(currentChar);
            } else if (currentChar == ')') {
                // When stk is not empty and last element of stk is (, that means it is a pair of valid parentheses
                // Just pop the last element of stk
                if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                } else {
                    // Invalid pair of (), therefore add the index of )
                    stk.push(i);
                }
                sb.append(currentChar);
            } else {
                sb.append(currentChar);
            }
        }
        // When stk is not empty, it means that we need to do the removal of parentheses
        // Find the index of the element of stk, and pop the correspoding element of stringbuilder
        while (!stk.isEmpty()) {
            sb.deleteCharAt(stk.pop());
        }
        return sb.toString();
    }
}
