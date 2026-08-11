package PrefixSum;

public class Q1749 {
    /**
     * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
     * Return the maximum absolute sum of any (possibly empty) subarray of nums.
     * Note that abs(x) is defined as follows:
     * If x is a negative integer, then abs(x) = -x
     * If x is a non-negative integer, then abs(x) = x.
     * 
     * Brute Force approach: emumerates everu possible subarray.
     * For each starting index, extend the ending index while maintaining a running sum
     * 
     * Time Complexity: O(n^2)
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                // currentSum need to abs with the instruction of questions
                result = Math.max(Math.abs(currentSum), result); 
            }
        }
        return result;
    }
}
