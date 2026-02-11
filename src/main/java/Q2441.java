import java.util.Arrays;

public class Q2441 {
    /**
     * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
     * Return the positive integer k. If there is no such integer, return -1.
     *
     * @param nums int[]
     * @return int
     */
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] + nums[rightIndex] == 0) {
                return nums[rightIndex];
            } else if (nums[leftIndex] + nums[rightIndex] < 0) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        // No integer that having positive integer k and negative -k also exists in the array
        return 0;
    }
}
