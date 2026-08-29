package PrefixSum;

import java.util.HashMap;

public class Q930PrefixSum {
    /**
     * PrefixSum approach.
     * 
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int[] prefixNum = new int[nums.length + 1];
        // Prefix Sum -> number of times it has appeared earlier
        HashMap<Integer, Integer> map = new HashMap<>();
        // Precalculate the prefix sum of array nums
        for (int i = 0; i < nums.length; i++) {
            prefixNum[i + 1] = prefixNum[i] + nums[i]; 
        }
        for (int num : prefixNum) {
            int diff = num - goal;
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            // After checking earlier prefixes, record the current prefix for later iterations
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return result;
    }
}
