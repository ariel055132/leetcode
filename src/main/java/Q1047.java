import java.util.Stack;

public class Q1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        // Traverse string
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // If stack is not empty and the latest element in stack == current traverse string, pop it
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                // otherwise, pop the element from current stack
                stack.push(ch);
            }
        }
        // If the stack is empty, return null
        if (stack.isEmpty()) {
            return null;
        } else {
            // Traverse the stack and append the element to stringbuilder
            for (Character element : stack) {
                sb.append(element);
            }
        }
        return sb.toString();
    }
}
