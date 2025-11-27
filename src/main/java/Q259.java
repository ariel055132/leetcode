import java.util.Arrays;

public class Q259 {
    /**
     * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
     *
     * Similar to 3-sum problem
     * Firstly, we sort the array first.
     * Traverse the array
     * Use two pointers (left and right) to check if the sum satisfies the condition.
     * The trick here is that if we found out: nums[i] + nums[left] + nums[right] < target
     * then for all right in (left, right] satisfy the condition.
     * Therefore, we have result += right - left; in the code
     * @param nums int[]
     * @param target int
     * @return result int
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum >= target) {
                    right--;
                } else {
                    result += right - left;
                    left++;
                }
            }
        }
        return result;
    }
}
