package BinarySearch;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * Edge Case:
 * int[] nums can empty?
 * duplicated elements in the array?
 *
 * O(n) -> Linear Search
 * O(log n) -> Binary Search
 */
public class Q704 {
    public int search(int[] nums, int target) {
        if (nums == null || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }
        if (nums.length == 1 && (nums[0] == target)) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            /**
             * [-1, 0, 3, 5, 9, 12], target = 9
             * left = 0 (-1), right = 5 (12)
             * mid = 0 + (5 - 0) / 2 = 3
             * nums[3] = 5, 5 < 9 (代表 nums[3] 之前的 element 都不是對的(F)，直接忽略它們，將 left 的 index 設定成 mid)
             * left = mid (3), right = 5
             * mid = 3 + (5 - 3) / 2 = 4
             * nums[4] = 9 == target
             * return 4
             */
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchDuplicate(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        return -1;
    }
}
