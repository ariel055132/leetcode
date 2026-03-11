package Heap;

public class Q3264 {
    /**
     * You are given an integer array nums, an integer k, and an integer multiplier.
     * You need to perform k operations on nums. In each operation:
     * 1. Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
     * 2. Replace the selected minimum value x with x * multiplier.
     * Return an integer array denoting the final state of nums after performing all k operations.
     * 
     * @param nums
     * @param k
     * @param multiplier
     * @return
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            minimumOpeartion(nums, multiplier);
        }
        return nums;
    }

    /**
     * Find the minimum value in nums
     * Times the minimum value with multiplier in nums
     * 
     * @param nums int[]
     * @param multiplier int
     */
    public void minimumOpeartion (int[] nums, int multiplier) {
        int minimumValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minimumValue) {
                minimumValue = nums[i];
                minIndex = i;
            }
        }
        nums[minIndex] = nums[minIndex] * multiplier;
    }
}
