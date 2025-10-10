package TwoPointers;

import java.util.Arrays;

public class Q611 {
    /**
     * Given an integer nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle
     *
     * Definition of a triangle
     * Let s1, s2, s3 be sides of triangle, and s1 < s2 < s3
     * If the three sides can form a triangle, it should be s1 + s2 > s3
     * @param nums integer array
     * @return result integer (number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle)
     */
    public int triangleNumber(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[i] < (nums[left] + nums[right])) {
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
