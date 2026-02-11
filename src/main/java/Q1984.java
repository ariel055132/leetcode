import java.util.Arrays;

public class Q1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);

        int left = 0;
        int right = k - 1;
        int result = Integer.MAX_VALUE;

        while (right < nums.length) {
            int currentResult = nums[right] - nums[left];
            result = Math.min(result, currentResult);
            left++;
            right++;
        }

        return result;
    }
}
