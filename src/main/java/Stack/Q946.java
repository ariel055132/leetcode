package Stack;

import java.util.Stack;

public class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int push : pushed) {
            stack.push(push);
            while (stack.size() > 0 && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.size() == 0;
    }
}
