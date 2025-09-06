import java.util.Arrays;

public class Q611 {
    public int triangleNumber(int[] nums) {
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
