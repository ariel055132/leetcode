package Stack;

import java.util.ArrayList;
import java.util.List;

public class Q1441 {
    /**
     * You are given an integer array target and an integer n.
     * You have an empty stack with the two following operations:
     * "Push": pushes an integer to the top of the stack.
     * "Pop": removes the integer on the top of the stack.
     * 
     * You also have a stream of the integers in the range [1, n].
     * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
     * If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
     * If the stack is not empty, pop the integer at the top of the stack.
     * If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
     * 
     * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
     * 
     * Solution
     * Traverse through the stream from 1 to n.
     * Every number all requires at least one push.
     * If the current number is the next value inside the target, keep it.
     * Otherwise, discard it (pop after push)
     * Stop the traversal when we got all the elements in the target
     * 
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int cur = 0;
        for (int num = 1; num <= n && cur < target.length; num++) {
            result.add("Push");
            if (num == target[cur]) {
                cur++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}
