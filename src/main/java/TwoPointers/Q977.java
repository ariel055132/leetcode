package TwoPointers;

import java.util.Arrays;

public class Q977 {
    /**
     * Given an integer array nums sorted in non-decreasing order
     * Return an array of the squares of each number sorted in non-decreasing order.
     *
     * 1. Square the value
     * 2. Sort the array
     *
     * @param nums int[]
     * @return squared_nums
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int squaredNum = nums[i] * nums[i];
            nums[i] = squaredNum;
        }
        Arrays.sort(nums);
        return nums;
    }
}
