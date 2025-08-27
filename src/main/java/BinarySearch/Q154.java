package BinarySearch;

public class Q154 {
    public int findMin(int[] nums) {
        // Edge Case 1: If nums is empty, no minimum value can be found, therefore return -1
        if (nums == null) {
            return -1;
        }
        /*
         * Edge Case 2:
         * If the first element of array is less than the last element of array, means the array is not rotated
         * Therefore, return the first element
         * However, the array may contain duplicates, need to do the pruning
         */
        int index = nums.length - 1;
        while (index != 0 && nums[0] == nums[index]) {
            index--;
        }
        if (nums[0] <= nums[index]) {
            return nums[0];
        }
        int left = 0;
        int right = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            /*
             * If nums[mid] is greater than or equal to nums[left], it means the pivot (the point of rotation) and thus the minimum element must be in the right half of the array.
             * This is because the left side is still sorted.
             * Therefore, we should move the left pointer to mid + 1 to continue the search in the right subarray.
             */
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
