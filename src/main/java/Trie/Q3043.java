package Trie;

import java.util.HashSet;

public class Q3043 {
    /**
     * You are given two arrays of positive integers arr1 and arr2. 
     * A common prefix of integers a and b is an integer c that matches the leading digits of both (e.g. 565 is a common prefix of 5655359 and 56554). 
     * Among all pairs (x, y) with x ∈ arr1 and y ∈ arr2, return the maximum number of digits in their longest common prefix. 
     * If no pair shares a prefix, return 0.
     * 
     * A common digit-prefix of two numbers is itself an integer formed by stripping trailing digits.
     * So every prefix of 12345 is 12345 → 1234 → 123 → … → 1. 
     * Put all prefixes of every number in arr1 in a HashSet. 
     * For each number in arr2, walk from the full number downward (x, then x/10, …); 
     * the first prefix that appears in the set is the longest common prefix for that pair.
     * 
     * @param arr1 int[]
     * @param arr2 int[]
     * @return
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            int x = num;
            while (x > 0) {
                set.add(x);
                x /= 10;
            }
        }

        for (int num : arr2) {
            int x = num;
            int numLen = String.valueOf(num).length();
            while (x > 0) {
                if (set.contains(x)) {
                    result = Math.max(result, numLen);
                }
                numLen--;
                x /= 10;
            }
        }
        return result;
    }
}
