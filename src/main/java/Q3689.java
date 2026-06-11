public class Q3689 {
    /**
     * You are given an integer array nums of length n and an integer k.
     * You need to choose exactly k non-empty nums[l..r] of nums. Subarrays may overlap, and the exact same subarray (same l and r) can be chosen more than once.
     * The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
     * The total value is the sum of the values of all chosen subarrays.
     * Return the maximum possible total value you can achieve.
     * 
     * Solution
     * For any subarray
     * max(subArray) <= globalMax
     * min(subArray) >= globalMin
     * 
     * Therefore: max(subArray) - min(subArray) <= globalMax - globalMin
     * That means the best possible value for one subarray is simply: globalMax - globalMin
     * Answer is (globalMax - globalMin) * k
     * 
     * @param nums
     * @param k
     * @return
     */
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return 1L * (max - min) * k;
    }
}
