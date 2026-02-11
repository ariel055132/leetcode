package Stack;

import java.util.Stack;

public class Q921 {
    public int midAddToMakeValid(String s) {
        int result = 0;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else {
                result++;
            }
        }
        return result + stk.size();
    }
}
