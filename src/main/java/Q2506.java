import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q2506 {
    public int similarPairs(String[] words) {
        int result = 0;
        // Map, Key -> Common Pattern of words; Value -> The frequencies of the common pattern
        Map<String, Integer> map = new HashMap<>();

        // Traverse the word
        for (String word : words) {
            TreeSet<Character> set = new TreeSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : set) {
                sb.append(c);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                result += map.get(s);
                map.put(s, map.get(s) + 1);
            }
        }

        return result;
    }
}
