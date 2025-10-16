package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2824 {
    /**
     * Given a 0-indexed integer array nums of length n and an integer target, return the number of pairs (i, j)
     * where 0 <= i < j < n and nums[i] + nums[j] < target
     *
     * Two-pointers + Sliding Window
     *
     * @param nums
     * @param target
     * @return
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(new ArrayList<>(nums));
        int result = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int currentSum = nums.get(left) + nums.get(right);
            if (currentSum > target) {
                right--;
            } else {
                result = (right - left);
                left++;
            }
        }
        return result;
    }
}
