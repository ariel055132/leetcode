package ArrayScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2089 {
    /**
     * You are given a 0-indexed integer array nums and a target element target.
     * A target index is an index i such that nums[i] == target.
     * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
     *
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        // Sort the array in place
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // Scan array and record every index holding target
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}
