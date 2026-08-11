package PrefixSum;

public class Q1749PrefixSum {
    /**
     * If prefix[i] is the sum of the first i elements, then the sum of subarray nums[left...right] is:
     * prefix[right + 1] - prefix[left]
     * 
     * Therefore, the absolute sum is:
     * |prefix[right + 1] - prefix[left]|
     * 
     * The largest absolute difference between any two prefix sums is:
     * maximumPrefix - minimumPrefix
     * 
     * We only need to track the current prefix sum and the minimum and maximum prefix sums encountered.
     * 
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int result = 0;
        int maximumPrefix = 0;
        int minimumPrefix = 0;
        for (int num : nums) {
            result += num;
            minimumPrefix = Math.min(minimumPrefix, result);
            maximumPrefix = Math.max(maximumPrefix, result);
        }
        return maximumPrefix - minimumPrefix;
    }
}
