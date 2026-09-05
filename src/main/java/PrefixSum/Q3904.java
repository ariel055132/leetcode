package PrefixSum;

public class Q3904 {
    public int firstStableIndex(int[] nums, int k) {
        int[] suffix = new int[nums.length - 1];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i+1], nums[i]);
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            if (maxValue - suffix[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
