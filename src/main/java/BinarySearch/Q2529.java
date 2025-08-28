package BinarySearch;

public class Q2529 {
    public int maximumCount(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int negativeNumber = binarySearch(nums, 0);
        int positiveNumber = nums.length - binarySearch(nums, 1);
        return Math.max(negativeNumber, positiveNumber);
    }

    protected int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // ensure left index element must less than target
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // greater or equal than target
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * nums = {-2, -1, -1, 1, 2, 3}
     * output = 3
     * Math.max(positive number = 3, negative number = 3)
     *
     * Find the zero Index, index less than zero (zero -> negative number
     * Find the one Index, index greater / equal to one -> positive number
     */
}
