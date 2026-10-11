package Simulation;

public class Q2778 {
    /**
     * You are given a 1-indexed integer array nums of length n.
     * An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
     * Return the sum of the squares of all special elements of nums.
     *
     * Simulate as the question stated.
     *
     * @param nums
     * @return
     */
    public int sumOfSquares(int[] nums) {
        // Initialize result to 0 and store the array length in numsLength
        int result = 0;
        int numsLength = nums.length;
        // Traverse array nums, visit every element using index i
        for (int i = 0; i < nums.length; i++) {
            // i + 1 because of 1-indexed integer array
            // Calculate numsLength % (i + 1). num stores the remainder.
            int num = numsLength % (i + 1);
            // Special element when the remainder is 0
            if (num == 0) {
                // Add the sum of the squares of special element
                result += (nums[i] * nums[i]);
            }
        }


        return result;
    }
}
