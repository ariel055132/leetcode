package PrefixSum;

public class Q53 {
    /**
     * Given an integer array nums, find the with the largest sum, and return its sum.
     * 
     * Enumerate all the subarray and calculate the largest sum of that subarray
     * 
     * Time Complexity: O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < nums.length; j++) {
                tmpSum += nums[j];
                result = Math.max(tmpSum, result);
            }
        }

        return result;
    }
}
