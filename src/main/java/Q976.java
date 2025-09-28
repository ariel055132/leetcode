import java.util.Arrays;

public class Q976 {
    /**
     * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
     * If it is impossible to form any triangle of a non-zero area, return 0.
     * Definition of a valid triangle is as following
     * Let s1, s2, s3 be the sides of triangle respectively, and s1 < s2 < s3
     * If it is a valid triangle, it should be s1 + s2 > s3
     * Approach:
     * 1. Sort the nums in ascending order
     * 2. Check the last 3 elements in nums, if these element can form a triangle, return the result
     * 3. Otherwise, return 0
     * @param nums int[] (length of triangles)
     * @return result
     */
    public int largestPerimeter(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // Sort the nums in ascending order
        Arrays.sort(nums);

        // Check the last 3 elements in nums, if these element can form a triangle, return the result
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i-2] + nums[i-1] > nums[i]) {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }

}
