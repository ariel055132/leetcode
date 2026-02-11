package BinarySearch;

public class Q33 {
    public int search(int[] nums, int target) {
        // Edge Case 1: No elements in nums
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // Find the mid element
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // Condition 1: the middle element equals to target, return mid~
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
