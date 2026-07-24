package PrefixSum;

public class Q1310 {
    /**
     * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
     * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
     * Return an array answer where answer[i] is the answer to the ith query.
     * 
     * Brute Force
     * Calculate the xor of elements 
     * 
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int xorResult = 0;
            int queriesStart = queries[i][0];
            int queriesEnd = queries[i][1];
            for (int j = queriesStart; j <= queriesEnd; j++) {
                xorResult ^= arr[j];
            }
            result[i] = xorResult;
        }
        return result;
    }
}
