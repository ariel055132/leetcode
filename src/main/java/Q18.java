import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 */
public class  Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // Use Set to ensure unique quadruplets {nums[a], nums[b], nums[c], nums[d]}, where a, b, c, d are distinct
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // add (long) to avoid hidden test case leads to ram overflow
                    long tmpSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmpSum == target) {
                        List<Integer> tmpResult = List.of(nums[i], nums[j], nums[left], nums[right]);
                        set.add(tmpResult);
                        left++;
                        right--;
                    } else if (tmpSum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}
