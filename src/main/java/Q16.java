import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array before using two-pointers approach
        Arrays.sort(nums);
        // Result to be returned
        int result = 0;
        // Save the current minimum value which nearest to target
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // Calculate the sum of the three elements
                int sum3 = nums[i] + nums[left] + nums[right];
                // If the sum equals to target, just return the target
                if (sum3 == target) {
                    return target;
                } else if (sum3 < target) {
                    left++;
                } else {
                    right--;
                }
                // If the sum is not equal to the target
                int diff = Math.abs(target - sum3);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum3;
                }
            }
        }


        return result;
    }
}
