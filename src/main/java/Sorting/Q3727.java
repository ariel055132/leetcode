package Sorting;

import java.util.Arrays;

public class Q3727 {
    /**
     * You are given an integer array nums. You may rearrange the elements in any order.
     * The alternating score of an array arr is defined as:
     * score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
     * Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.
     *
     * By observing the example, we can get a simple conclusion as follows:
     * Plus the elements with even indices in array
     * Minus the elements with odd indices in array
     * However, how to implement the conclusion as above?
     * Add larger squares, minus smaller squares
     *
     * Imagine currently add a small square 1 and subtract a large square, 9:
     * Current contribution: +1 - 9 = -8
     * Swap those two elements so their signs switch: +9 - 1 = 8
     *
     * Suppose small < large:
     * Before: small - large
     * After: large - small
     *
     * Therefore, if any subtracted square is larger than an added square, swapping them improves the answer
     *
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum(int[] nums) {
        long result = 0;
        // Square every element
        long[] squaredNums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squaredNums[i] = (long) nums[i] * nums[i];
        }
        // Sort the squares
        Arrays.sort(squaredNums);
        // Subtract the smallest nums.length / 2 squares
        for (int i = 0; i < nums.length / 2; i++) {
            result -= squaredNums[i];
        }
        // Add all remaining squares
        for (int i = nums.length / 2; i < nums.length; i++) {
            result += squaredNums[i];
        }

        return result;
    }
}
