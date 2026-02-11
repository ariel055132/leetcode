package TwoPointers;

public class Q2563_BruteForce {
    /**
     * Given a 0-indexed
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) {
                    result++;
                }
            }
        }
        return result;
    }
}
