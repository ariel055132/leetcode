package PrefixSum;

import java.util.HashMap;

public class Q1524PrefixSum {
    /**
     * counts how many contiguous subarrays have an odd sum.
     * Instead of calculating every subarray in \(O(n^2)\), it tracks whether each prefix sum is even or odd, reducing the time complexity to \(O(n)\).
     * 
     * This difference is odd only when the prefix sums have different parity:
     * even − odd = odd
     * odd − even = odd
     * 
     * Therefore:
     * If the current prefix sum is even, it forms an odd-sum subarray with every previous odd prefix.
     * If the current prefix sum is odd, it forms one with every previous even prefix.
     * 
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int result = 0;
        int tmpResult = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Prefix Sum of 0 is even number, precompute for it
        for (int i = 0; i < arr.length; i++) {
            tmpResult += arr[i];
            if (tmpResult % 2 == 0) {
                // Even + odd -> odd 
                result += map.getOrDefault(1, 0) % MOD;
            } else {
                // odd + even -> odd
                result += map.getOrDefault(0, 0) % MOD;
            }
            map.put(tmpResult % 2, map.getOrDefault(tmpResult % 2, 0) + 1);
        }

        return result;
    }
}
