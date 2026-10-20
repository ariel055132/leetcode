package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1930 {
    /**
     *
     * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
     * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
     * A palindrome is a string that reads the same forwards and backwards.
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * For example, "ace" is a subsequence of "abcde".
     *
     * Use hashmap to record the first appearance and last appearance of each character
     *
     * @param s
     * @return
     */
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            first.putIfAbsent(ch, i);
            last.put(ch, i);
        }
        for (char ch : first.keySet()) {
            int left = first.get(ch);
            int right = last.get(ch);
            Set<Character> mid = new HashSet<>();
            for (int i = left + 1; i < right; i++) {
                mid.add(s.charAt(i));
            }
            result += mid.size();
        }

        return result;
    }

    public int countPalindromicSubsequenceBrute(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    String str = new String(new char[]{s.charAt(i), s.charAt(j), s.charAt(k)});
                    if (isPalindrome(str)) {
                        set.add(str);
                    }
                }
            }
        }
        return set.size();
    }

    private boolean isPalindrome(String s) {
        char firstCh = s.charAt(0);
        char midCh = s.charAt(1);
        char lastCh = s.charAt(2);
        return firstCh == lastCh;
    }
}
