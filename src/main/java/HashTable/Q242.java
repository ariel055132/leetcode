package HashTable;

import java.util.Arrays;

public class Q242 {
    /**
     * Given two strings s and t, return true if t is an of s, and false otherwise.
     * 
     * @param s String 
     * @param t String 
     * @return s == t
     */
    public boolean isAnagram(String s, String t) {
        /**
         * Approach: Sort and compare
         * Anagrams contain the same characters, so they're identical when sorted
         * 1. Convert both strings to character arrays
         * 2. Sort both arrays
         * 3. Compare the sorted arrays for equality
         */
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(tCharArray, sCharArray);
    }
}
