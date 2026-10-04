package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q22 {
    /**
     * Give n pairs of parentheses, write a function to generate all combinations of well-formed parentheses
     *
     * Generate all (parentheses) strings of length 2n, then check one by one
     * Each position of strings has two choices, ( and ), this will lead to 2^(2n) = 4^n elements
     * We can check validity with stack. (Q20)
     *
     * Procedure
     * 1. Create a character array of length 2n.
     * 2. At each position, recursively try both ( and )
     * 3. Once the array is full, scan it to check validity.
     * 4. If valid, add a copy to the result
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, new char[2 * n], result);
        return result;
    }

    private void generate(int index, char[] current, List<String> result) {
        if (index == current.length) {
            if (isValid(current)) {
                result.add(new String(current));
            }
            return;
        }
        current[index] = '(';
        generate(index + 1, current, result);

        current[index] = ')';
        generate(index + 1, current, result);
    }

    private boolean isValid(char[] current) {
        Stack<Character> stack = new Stack<>();
        for (char ch : current) {
            if (ch == '(') {
                stack.add(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
