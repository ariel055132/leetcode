package PrefixSum;

import java.util.HashSet;

public class Q2996 {
    /**
     * You are given a 0-indexed array of integers nums.
     * A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.
     * Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.
     * 
     * 1. Insert every value from nums into a HashSet.
     * 2. Initialize prefixSum = nums[0].
     * 3. Starting at index 1, continue while: nums[i] == nums[i - 1] + 1
     * 4. Add each sequential value to prefixSum.
     * 5. Set candidate = prefixSum.
     * 6. While candidate exists in the set, increment it.
     * 7. Return the first missing candidate.
     * 
     * @param nums
     * @return
     */
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int sequentialPrefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sequentialPrefixSum += nums[i];
            } else {
                break;
            }
        }
        while (set.contains(sequentialPrefixSum)) {
            sequentialPrefixSum++;
        }
        return sequentialPrefixSum;
    }
}
