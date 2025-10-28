package Stack;

import java.util.Stack;

public class Q844 {
    public boolean backSpaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            } else if (s.charAt(i) == '#' && !stackS.isEmpty()) {
                stackS.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stackT.push(t.charAt(i));
            } else if (t.charAt(i) == '#' && !stackT.isEmpty()) {
                stackT.pop();
            }
        }
        return stackS.equals(stackT);
    }
}
