package HashTable;

import java.util.HashMap;

public class Q242_HashTable {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        // Count the frequency of each character in string s
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        // Traverse string t and verify each character exists in s with matching frequency
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            // If character from t is not in s, they cannot be anagrams
            if (!map.containsKey(character)) {
                return false;
            } else {
                int times = map.get(character);
                times--;
                // If frequency becomes negative, t has more of this character than s, they cannot be anagrams
                if (times < 0) {
                    return false;
                }
                map.put(character, times);
            }
        }
        return true;
    }
}
