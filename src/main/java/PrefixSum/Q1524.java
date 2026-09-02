package PrefixSum;

public class Q1524 {
    /**
     * Given an array of integers arr, return the number of subarrays with an odd sum.
     * Since the answer can be very large, return it modulo 109 + 7.
     * 
     * Enumerate all the subarray 
     * Calculate all the sum of subarray
     * If sum % 2 == 1, result++
     * return the result
     * 
     * Time Complexity: O(n^2)
     * 
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmpResult = 0;
            for (int j = i; j < arr.length; j++) {
                tmpResult += arr[j];
                if (tmpResult % 2 != 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
