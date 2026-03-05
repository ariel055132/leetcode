package HashTable;

public class Q2874 {
    /**
     * You are given a 0-indexed integer array nums.
     * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. 
     * If all such triplets have a negative value, return 0.
     * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
     * 
     * Constraints:
     * 3 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     * 
     * Approach: Prefix-Suffix Arrays
     * With nums.length up to 10^5, a brute force O(n^3) solution is too slow.
     * Analyzing the formula (nums[i] - nums[j]) * nums[k] reveals the key insight:
     * - To maximize the result, we need the largest element before index j (for nums[i])
     * - And the largest element after index j (for nums[k])
     * Solution: Precompute two arrays to efficiently query these values:
     * - prefix[j]: maximum element in range [0, j-1]
     * - suffix[j]: maximum element in range [j+1, n-1]
     * For each middle position j, calculate (prefix[j] - nums[j]) * suffix[j] and track the maximum.
     * Time: O(n), Space: O(n)
     * 
     * @param nums
     * @return
     */
    public long maximumTripletValue(int[] nums) {
        // Track the maximum element before j (prefix)
        // prefix[i] = max element from 0 to i - 1
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i-1], prefix[i-1]);
        }
        // Track the maximum element after j (suffix)
        // suffix[i] = max element from i+1 to nums.length-1
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(nums[i+1], suffix[i+1]);
        }

        long result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            long currentValue = (long)(prefix[i] - nums[i]) * suffix[i];
            // Prevent negative value
            result = Math.max(result, currentValue);
        }
        return result;
    }

}
