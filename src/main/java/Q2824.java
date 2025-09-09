import java.util.Collections;
import java.util.List;

public class Q2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int result = 0; // result returned
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            // If sum of left and right index >= target, right-- to lower the sum
            if (nums.get(left) + nums.get(right) >= target) {
                right--;
            } else {
                result += (right - left);
                left++;
            }
        }
        return result;
    }
}
