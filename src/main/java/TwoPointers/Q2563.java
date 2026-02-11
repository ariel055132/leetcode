package TwoPointers;

import java.util.Arrays;

public class Q2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            int minLow = lower - nums[i];
            int maxUpp = upper - nums[i];
            int left = lowerBound(nums, i + 1, nums.length, minLow);
            int right = upperBound(nums, i + 1, nums.length, maxUpp);
            result += (right - left);
        }
        return result;
    }

    public int lowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int upperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
