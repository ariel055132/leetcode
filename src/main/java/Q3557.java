import java.util.HashMap;
import java.util.Map;

public class Q3557 {
    public int maxSubstring(String word) {
        int result = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!freq.containsKey(c)) {
                freq.put(c, i);
            } else if (i - freq.get(c) + 1 >= 4) {
                result++;
                freq.clear();
            }
        }

        return result;
    }
}
