package Quests;

import java.util.Stack;

public class Q8 {
    // Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int secondNum = (int) stk.pop();
                int firstNum = (int) stk.pop();
                if (token.equals("+")) {
                    stk.push(firstNum + secondNum);
                } else if (token.equals("-")) {
                    stk.push(firstNum - secondNum);
                } else if (token.equals("*")) {
                    stk.push(firstNum * secondNum);
                } else {
                    stk.push(firstNum / secondNum);
                }
            } else {
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}
