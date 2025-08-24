package BinarySearch;

public class Q153 {
    public int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}

/**
 * [4,5,6,0,1,2]
 * left = 0 -> nums[0] = 4
 * right = 6 -> nums[6] = 2
 * mid = 0 + (6 - 0) / 2 = 3 -> nums[3] = 0
 * (nums[0]) 4 > (nums[mid]) 0 -> right =
 *
 */
