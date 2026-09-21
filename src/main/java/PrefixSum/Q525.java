package PrefixSum;

public class Q525 {
    /**
     * Given a binary array nums
     * Return the maximum length of a contiguous subarray with an equal number of 0 and 1.
     * 
     * Enumerate every possible subarray within nums.
     * Count the number of zeros and ones in each subarray
     * Find out the maximize size subarray with equal number of zeros and ones out of them.
     * 
     * Time Complexity: O(n^2)
     * 
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroes = 0; // occurence of 0 in nums
            int ones = 0; // occurence of 1 in nums
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeroes++;
                else ones++;
                if (zeroes == ones) result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }
}
