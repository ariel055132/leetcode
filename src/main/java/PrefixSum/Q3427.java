package PrefixSum;

public class Q3427 {
    /**
     * You are given an integer array nums of size n. For each index i where 0 <= i < n, define a nums[start ... i] where start = max(0, i - nums[i]).
     * Return the total sum of all elements from the subarray defined for each index in the array.
     * 
     * Brute Force
     * @param nums int[]
     * @return int
     */
    public int subarraySum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                result += nums[j];
            }
        }
        return result;
    }

    /**
     * Prefix Sum
     * 
     * @param nums
     * @return
     */
    public int subArraySum(int[] nums) {
        int result = 0;
        int[] data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = data[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            int sum = data[i + 1] - data[start];
            result += sum;
        }
        return result;
    }
}
