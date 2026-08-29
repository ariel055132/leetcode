package PrefixSum;

public class Q560 {
    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * Brute Force Approach:
     * Consider every possible subarray of the given nums array,
     * find the sum of the elements of each of those subarrays and check for the equality of the sum obtained with the given k.
     * Whenever the sum equals k, we can increment the count used to store the required task.
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i ; j < nums.length; j++) {
                tmpSum += nums[j];
                if (tmpSum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
