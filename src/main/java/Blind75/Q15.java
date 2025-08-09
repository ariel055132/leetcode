package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>(); // Use set to avoid duplicates
        // Edge case: if the input array is null or has less than 3 elements, it cannot form a triplet
        // Return an empty list in this case
        if (nums == null || nums.length < 3) {
            return result;
        }
        // Sort the array to facilitate the two-pointer technique
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            // Edge case: if the current number is greater than zero, we can break early
            if (nums[index] > 0) {
                break;
            }
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if (sum == 0) {
                    // Found a triplet that sums to zero
                    seen.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                    /*
                    // Move both pointers inward to find other potential triplets
                    while (left < right) {
                        if (nums[left] == nums[left + 1]) {
                            // Skip duplicates for the left pointer
                            left++;
                        } else {
                            break;
                        }
                    }
                    while (left < right) {
                        if (nums[right] == nums[right - 1]) {
                            // Skip duplicates for the right pointer
                            right--;
                        } else {
                            break;
                        }
                    }

                     */
                } else if (sum < 0) {
                    // If the sum is less than zero, move the left pointer to the right to increase the sum
                    left++;
                } else {
                    // If the sum is greater than zero, move the right pointer to the left to decrease the sum
                    right--;
                }
            }
        }
        result.addAll(seen);
        return result;
    }
}
