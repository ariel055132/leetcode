import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1403 {
    public List<Integer> minSubsequence(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int currentSum = 0;
        int halfTotalSum = totalSum / 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.add(nums[i]);
            if (currentSum > halfTotalSum) {
                break;
            }
        }

        return result;
    }
}
