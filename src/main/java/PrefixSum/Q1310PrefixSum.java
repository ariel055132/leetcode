package PrefixSum;

public class Q1310PrefixSum {
    /**
     * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
     * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
     * Return an array answer where answer[i] is the answer to the ith query.
     * 
     * Prefix Sum Approach
     * Create prefix with length arr.length + 1.
     * Set prefixArr[0] = 0
     * Calculate prefix[i + 1] = prefix[i] ^ arr[i].
     * For each [left, right], calculate:
     * prefixArr[right + 1] ^ prefixArr[left]
     * 
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefixArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixArr[i + 1] = arr[i] ^ prefixArr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixArr[end + 1] ^ prefixArr[start];
        }
        return result;
    }
}
