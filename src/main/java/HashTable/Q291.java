package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q291 {
    /**
     * Given a pattern and a string s, return true if s matches the pattern.
     * A string s matches a pattern if there is some bijective mapping of single characters to non-empty strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.
     * 
     */
    Map<Character, String> map = new HashMap();
    public boolean wordPatternMatch(String pattern, String s) {
        // If the pattern is exhausted, the string must also be exhausted.
        if (pattern.isEmpty()) return s.isEmpty();
        // containsKey(character) ensures a repeated character uses its existing substring.
        if (map.containsKey(pattern.charAt(0))) {
            // If the first character already has a mapping, check that exact prefix.
            String value = map.get(pattern.charAt(0));
            if (value.length() > s.length() || !s.substring(0, value.length()).equals(value)) {
                return false;
            }

            if (wordPatternMatch(pattern.substring(1), s.substring(value.length()))) {
                return true;
            }
        } else {
            // Otherwise, try every nonempty prefix as a new mapping.
            for (int i = 1; i <= s.length(); i++) {
                // containsValue(substring) prevents another character from using that same substring.
                // Skip a candidate if another character already uses it.
                if (map.containsValue(s.substring(0, i))) continue;
                map.put(pattern.charAt(0), s.substring(0, i));
                if (wordPatternMatch(pattern.substring(1), s.substring(i))) {
                    return true;
                }
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
