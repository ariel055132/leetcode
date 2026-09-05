package PrefixSum;

public class Q974 {
    /**
     * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
     * A subarray is a contiguous part of an array.
     * 
     * Checking all possible subarrays and counting those whose sums are divisible by k.
     * Will lead to TLE
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        // Iterate through all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            // For each starting index, look at every possible ending index
            for (int j = i; j < nums.length; j++) {
                // Calculate the sum of the subarray from the starting index to the ending index
                tmpSum += nums[j];
                // Check if the sum is divisible by k
                if (tmpSum % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
