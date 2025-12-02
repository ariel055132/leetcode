package TwoPointers;

import java.util.Arrays;

public class Q1679 {
    /**
     * You are given an integer array nums and an integer k.
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     * Return the maximum number of operations you can perform on the array.
     *
     * Sort the input array
     * Place one pointer at the start and another at the end
     * Adjust pointers based on sum comparison with target k
     * When sum equals k, count the operation and move both pointers inward
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == k) {
                result++;
                right--;
                left++;
            } else if (currentSum > k) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
