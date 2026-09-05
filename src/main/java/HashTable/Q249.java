package HashTable;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        // Create a hash map from a signature to a list of strings
        // Key: Pattern, strings with that pattern
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String pattern = pattern(str);
            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Creates its shift-invariant signature
     * 
     * @param s
     * @return
     */
    public String pattern(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1) {
            return "";
        }
        for (int i = 1; i < s.length(); i++) {
            // Calculate the cyclic difference between every adjacent pair
            int diff = s.charAt(i) - s.charAt(i-1);
            diff = (diff + 26) % 26;
            sb.append(diff).append(",");
        }
        return sb.toString();
    }
}
