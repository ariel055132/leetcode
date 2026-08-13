package PrefixSum;

public class Q53PrefixSum {
    /**
     * Prefix Sum Apporach 
     * For any subarray [left, right]:
     * \[sum(left,right)=prefix[right]-prefix[left-1]\]
     * To maximize the subarray sum ending at right, subtract the smallest prefix sum seen before it.
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int minPrefixSum = 0;
        int currentPrefixSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum += nums[i];    
            result = Math.max(result, currentPrefixSum - minPrefixSum); 
            minPrefixSum = Math.min(minPrefixSum, currentPrefixSum);
        }
        return result;
    }
}
