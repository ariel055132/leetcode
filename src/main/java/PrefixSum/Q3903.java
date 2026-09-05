package PrefixSum;

public class Q3903 {
    /**
     * You are given an integer array nums of length n and an integer k.
     * For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).
     * max(nums[0..i]) is the largest value among the elements from index 0 to index i.
     * min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
     * An index i is called stable if its instability score is less than or equal to k.
     * Return the smallest stable index. If no such index exists, return -1.
     * 
     * As 1 <= nums.length <= 100, brute force is applicable
     * Simulate as the question stated
     * 
     * Time Complexity: O(n^2)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];
            // Find the largest value among the elements from index 0 to index i.
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            // Find the smallest value among the elements from index i to index n - 1.
            for (int j = i; j < nums.length; j++) {
                minVal = Math.min(minVal, nums[j]);
            }
            if (maxVal - minVal <= k) {
                return i;
            }
        }

        return -1;
    }
}
