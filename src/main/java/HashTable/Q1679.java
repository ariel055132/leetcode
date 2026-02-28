package HashTable;

import java.util.HashMap;

public class Q1679 {
    /**
     * You are given an integer array nums and an integer k.
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     * Return the maximum number of operations you can perform on the array.
     * 
     * HashMap Approach (no need to do the sorting~)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        // Save the frequencies of numbers in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference 
            int diff = k - nums[i];
            if (!map.containsKey(diff)) {
                // Increment the count instead of always setting to 1
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } else {
                // Find two numbers from the array whose sum equals k
                result++;
                // When the value is 0, remove the element in the key
                if (map.get(diff) == 1) map.remove(diff);
                // Otherwise, just decrease the value by 1
                else map.put(diff, map.get(diff) - 1);
            }
        }
        return result;
    }
}
