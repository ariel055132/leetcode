package TwoPointers;

import java.util.HashMap;

public class Q161 {
    /**
     * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
     * 
     * A string s is said to be one distance apart from a string t if you can:
     * 1. Insert exactly one character into s to get t.
     * 2. Delete exactly one character from s to get t.
     * 3. Replace exactly one character of s with a different character to get t.
     * 
     * @param s String
     * @param t String
     * @return 
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        // If difference of length s and t > 1, that means it cannot implement exactly one operation to make both string equal
        if (Math.abs(sLen - tLen) > 1) return false;
        int sIndex = 0;
        int tIndex = 0;
        // Traverse both string, skip those same characters
        while (sIndex < sLen && tIndex < tLen && s.charAt(sIndex) == t.charAt(tIndex)) {
            sIndex++;
            tIndex++;
        }
        // If both string are the same, that means we do not need to insert/delete/replace, therefore return false
        if (sIndex == sLen && tIndex == tLen) return false;
        // Situation: difference between string s and t, need to decide insertion/deletion/replacement to make both string same
        // If length of s and t are the same, only replacement
        if (sLen == tLen) {
            HashMap<Character, Integer> diff = new HashMap<>();
            int mismatches = 0;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    mismatches++;
                }
                char c = s.charAt(i);
                diff.put(c, diff.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                diff.put(c, diff.getOrDefault(c, 0) - 1);
            }
            if (mismatches != 1) {
                return false;
            }
            int plusOne = 0;
            int minusOne = 0;
            for (int v : diff.values()) {
                if (v == 0) {
                    continue;
                }
                if (v == 1) {
                    plusOne++;
                } else if (v == -1) {
                    minusOne++;
                } else {
                    return false;
                }
            }
            return plusOne == 1 && minusOne == 1;
        } else if (sLen > tLen) {
            // If length of s is greater than length of t, delete one character from string s
            // And find out whether the new string s is equal to string t
            return s.substring(sIndex + 1).equals(t.substring(tIndex));
        } else {
            // If length of s is smaller than length of t, delete one character from string t
            // And find out whether the new string s is equal to string t
            return s.substring(sIndex).equals(t.substring(tIndex + 1));
        }
    }
}
