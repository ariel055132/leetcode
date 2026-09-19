package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q1081 {
    /**
     * The key insight is to postpone larger characters whenever it is safe. 
     * If your current answer ends in c and you encounter a, removing c lets the smaller a come earlier—but you can remove c only if another occurrence remains later.
     * 
     * Count every character. The first loop fills map with frequencies.
     * Consume the current occurrence.
     * Skip characters already selected.
     * Remove characters that can safely be postponed.
     * Add the current character, mark it selected, and eventually read the stack from bottom to top to form the answer.
     * 
     * @param s
     * @return
     */
    public String smallestSubsequqnce(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        boolean[] seen = new boolean[26];
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for (char ch : s.toCharArray()) {
            int charIdx = ch - 'a';
            int val = map.get(ch);
            map.put(ch, val - 1);
            if (seen[charIdx]) {
                continue;
            }
            while (stack.size() > 0 && stack.peek() > ch && map.get(stack.peek()) > 0) {
                char removed = stack.pop();
                seen[removed - 'a'] = false; 
            }
            stack.add(ch);
            seen[charIdx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
