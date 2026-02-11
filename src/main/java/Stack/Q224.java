package Stack;

import java.util.Stack;

public class Q224 {
    public int calculate(String s) {
        int result = 0;
        int sign = 1; // Control Positive Number and Negative Number
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int currentNum = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    currentNum = currentNum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                result += sign * currentNum;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                integerStack.push(result);
                integerStack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result += result * integerStack.pop() + integerStack.pop();
            }
        }


        return result;
    }
}
