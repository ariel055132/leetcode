package PrefixSum;

import java.util.HashMap;

public class Q560PrefixSum {
    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * PrefixSum approach
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] prefixNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixNums[i + 1] = prefixNums[i] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : prefixNums) {
            /**
             * currentPrefix - previousPrefix = k
             * previousPrefix = currentPrefix - k
             */
            int diff = num - k;
            // Count matches before inserting the current prefix
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            map.put(num, map.getOrDefault(num, 0)+1);
            
        }
        return result;
    }
}
