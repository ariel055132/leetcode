import java.util.HashMap;

public class Q1 {
    /**
     * Brute Force
     * Return indices of the two number such that they add up to target
     *
     * Check all pair of the number whether their sum is target
     * Precisely, for each number check all the number before it
     *
     * Time Complexity; O(n^2)
     * @param nums an array of integers
     * @param target integer
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // If you cannot find, set the result array as {-1, -1}
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    /**
     * HashMap Approach
     *
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        int[] result = new int[2];
        // Map, Key: element in nums, Value: Position of element in nums
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                // Return one result is ok.
                return result;
            }
            // Put the element into hashmap.
            map.put(nums[i], i);
        }
        return result;
    }
}
