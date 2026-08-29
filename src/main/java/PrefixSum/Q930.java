package PrefixSum;

public class Q930 {
    /**
     * Given a binary array nums and an integer goal
     * Return the number of non-empty subarrays with a sum goal
     * A subarray is a contiguous part of the array.
     * 
     * Brute force.
     * Enumerate all the subarray inside nums
     * 
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmpResult = 0;
            for (int j = i; j < nums.length; j++) {
                tmpResult += nums[j];
                if (tmpResult == goal) {
                    result++;
                }
            }
        }
        return result;
    }
}
