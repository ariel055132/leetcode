import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Q1_FollowUp {
    /**
     * Find as many as possible disjoint pair whose sum is target
     *
     * - How to maintain hash map
     * Store all the index that the value appear
     * - How to take one element in the value of the hash map
     * Using Stack, Queue, List to take the element
     *
     * Test Case:
     * 1. Duplicated elements
     * 2. Answer not found
     */
    public ArrayList<ArrayList<Integer>> twoIntegerSumTarget(int[] nums, int target) {
        /**
         * Saving the position of element in nums
         * Key: elements in nums (Integer)
         * Value: element position in nums (Integer)
         */
        HashMap<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>>();
        // Return Result
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference
            int diff = target - nums[i];
            // If the hashmap have another elements == difference, put them together
            if (map.containsKey(diff)) {
                // Put the result into the arrayList
                ArrayList<Integer> list = new ArrayList<Integer>();
                // Obtain the value with diff in hashmap
                Stack<Integer> targetStack = map.get(diff);
                // Add the index into the list
                list.add(i);
                list.add(targetStack.pop());
                // Add the list to the result
                result.add(list);
                // If the stack is empty after pop, remove it
                if (targetStack.isEmpty()) {
                    map.remove(diff);
                }
            } else {
                /**
                 * If the hashmap does not contain the value of diff, save the element position into the Stack
                 * Check whether the element is existed in hashmap
                 * If existed, save the position
                 * If not existed, create a new Stack and save the position
                 */
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new Stack<Integer>());
                }
                map.get(nums[i]).push(i);
            }
        }
        return result;
    }
}
