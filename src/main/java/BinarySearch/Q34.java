package BinarySearch;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int leftIndex = searchLeftIndex(nums, target);
        int rightIndex = searchRightIndex(nums, target);
        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    protected int searchLeftIndex(int[] nums, int target) {
        int leftIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leftIndex;
    }

    protected int searchRightIndex(int[] nums, int target) {
        int rightIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return rightIndex;
    }
}
