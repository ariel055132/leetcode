package BiWeeklyContest186;

public class Q2 {
    // Brute force: check every pair whose indices are at least k apart.
    // Time: O(n^2). Extra space: O(1).
    public int maxValidPairSumBruteForce(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i + k; j < nums.length; j++) {
                result = Math.max(result, nums[i] + nums[j]);
            }
        }
        return result;
    }

    /**
     * You are given an integer array nums of length n and an integer k.
     * A pair of indices (i, j) is called valid if:
     * 0 <= i < j < n
     * j - i >= k
     * Return the maximum value of nums[i] + nums[j] among all valid pairs.
     * 
     * keep the largest eligible left-hand value as you move the right index j forward.
     * 
     * 
     * @param nums
     * @param k
     * @return
     */
    public int maxValidPairSum(int[] nums, int k) {
        int maxI = 0; // Largest eligible left-hand value
        int result = 0; // Largest valid pair sum found
        // j = k as (j - i) >= k
        for (int j = k; j < nums.length; j++) {
            // Index j-k becomes eligible as a left partner.
            maxI = Math.max(maxI, nums[j - k]);
            // Best pair ending at j, compared with the overall best.
            result = Math.max(result, maxI + nums[j]);
        }
        return result;
    }
}
