package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q266 {
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
