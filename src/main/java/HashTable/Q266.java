package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q266 {
    /**
     * Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.
     * Insight: In any palindrome, characters must be symmetrically positioned around the center
     * For character frequencies, this means:
     * 1. Even-length palindromes (e.g: "abba"):
     * Every character must appear an even number of times
     * Pair up symmetrically on both sides
     * 2. Odd-length palindromes (e.g: "racecar"):
     * At most one character can appear an odd number of times
     * That character sits in the middle
     * All other character must appear an even number of times to pair up
     * 
     * @param s String
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        
        // For palindrome permutation: at most 1 character can have odd count
        return oddCount <= 1;
    }
}
