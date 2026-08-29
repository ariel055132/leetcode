package PrefixSum;

public class Q3152 {
    /**
     * An array is considered special if every pair of its adjacent elements contains two numbers with different parity. 
     * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that nums[fromi..toi] is special or not.
     * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
     * 
     * Brute force
     * Traversing the entire subarray for each query queries[i] and checking if its elements alternate between even and odd parity.
     * 
     * O(n^2)
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];
            
            boolean isSpecial = true;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i - 1] % 2 == nums[i] % 2) {
                    isSpecial = false;
                    break;
                }
            }
            result[q] = isSpecial;
        }
        return result;
    }
}
