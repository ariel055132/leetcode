package Stack;

import java.util.Stack;

public class Q1006 {
    /**
     * The factorial of a positive integer n is the product of all positive integers less than or equal to n.
     * For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
     *
     * We make a clumsy factorial using the integers in decreasing order by swapping out the multiply operations for a fixed rotation of operations with multiply '*', divide '/', add '+', and subtract '-' in this order.
     * For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
     *
     * these operations are still applied using the usual order of operations of arithmetic. We do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.
     * floor division
     *
     * Time Complexity: O(N), where N is single pass of numbers
     * Space Complexity: O(N)
     */
    public int clumsy(int n) {
        int result = 0; // return result
        /*
         * opCount, control the arithmetic operation
         * opCount % 4 == 0 -> multiplication (*)
         * opCount % 4 == 1 -> division (/)
         * opCount % 4 == 2 -> addition (+)
         * opCount % 4 == 3 -> subtraction (-)
         */
        int opCount = 0;
        /**
         * Use Stack for Operator Precedence Management
         * 1. High Precedence (*,/): Evaluate immediately with stack top
         * 2. Low Precedence (+,-): Push values to defer evaluation
         */
        Stack<Integer> stk = new Stack<>();
        stk.push(n);
        // Process / Traverse numbers in descending order
        for (int i = n-1; i > 0; i--) {
            if (opCount % 4 == 0) {
                stk.push(stk.pop() * i);
            } else if (opCount % 4 == 1) {
                stk.push(stk.pop() / i);
            } else if (opCount % 4 == 2) {
                stk.push(i);
            } else if (opCount % 4 == 3) {
                stk.push(-i);
            }
            opCount++;
        }
        for (int val : stk) {
            result += val;
        }
        return result;
    }
}
