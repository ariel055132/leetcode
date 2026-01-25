import java.util.Arrays;

public class Q1877 {
    /**
     * The pair sum of a pair (a, b) is equal to a + b
     * Given an array of nums of even length n, pair up the elements of nums into n / 2 pairs such that
     * 1. Each element of nums is in exactly one pair, and
     * 2. The maximum pair sum is minimized
     *
     * Return the minimized maximum pair sum after optimally pairing up the elements
     *
     * According to the example, we can find that the pair as following:
     * Example 1
     * 3 5 2 3
     * -> 2 3 3 5
     * -> (2, 5), (3, 3)
     * -> Math.max(7, 6) -> 7
     *
     * Example 2
     * 3 5 4 2 4 6
     * -> 2 3 4 4 5 6
     * -> (2, 6), (3, 5), (4, 4)
     * -> Math.max(8, 8, 8) -> 8
     *
     * Therefore, we can use two-pointers approach to solve the problem
     *
     * @param nums int[]
     * @return maxSum int
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, currentSum);
            left++;
            right--;
        }

        return maxSum;
    }
}
