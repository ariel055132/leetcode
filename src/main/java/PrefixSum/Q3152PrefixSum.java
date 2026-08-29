package PrefixSum;

public class Q3152PrefixSum {
    /**
     * An array is considered special if every pair of its adjacent elements contains two numbers with different parity. 
     * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that nums[fromi..toi] is special or not.
     * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
     * 
     * Prefix Sum
     * 
     * 
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixNums = new int[n];
        boolean[] result = new boolean[queries.length];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] % 2 != nums[i] % 2) {
                prefixNums[i] = prefixNums[i - 1];
            } else {
                // Both are odd and evens, add + 1
                prefixNums[i] = prefixNums[i - 1] + 1;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int ans = prefixNums[right] - prefixNums[left];
            if (ans == 0) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
