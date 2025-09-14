import java.util.Collections;
import java.util.HashMap;

public class Q3541 {
    /**
     * Return the sum of the two frequencies. (maximum frequency from vowelMap & consonantMap)
     * 1. Use a hashmap to save the frequency of vowel (a, e, i, o, u) -> vowelMap
     * 2. Use a hashmap to save the frequency of consonant (all other letters excluding vowel) -> consonantMap
     * 3. Obtain the maximum frequency from vowelMap
     * 4. Obtain the maximum frequency from consonantMap
     * 5. Sum the frequencies (from Step 3 and Step 4)
     *
     * @param s
     * @return
     */
    public int maxFreqSum(String s) {
        // Edge Case: If string s is null, return 0.
        if (s == null) {
            return 0;
        }
        s = s.toLowerCase();
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        HashMap<Character, Integer> consonantMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
            } else {
                consonantMap.put(ch, consonantMap.getOrDefault(ch, 0) + 1);
            }
        }
        // Check the map is null or not before finding the maximum frequency from vowelMap.
        // If the map is null, put the value as 0
        // Otherwise, find the maximum value of the map
        int vowelMaxFreq = vowelMap.isEmpty() ? 0 : Collections.max(vowelMap.values());
        int consonantMaxFreq = consonantMap.isEmpty() ? 0 : Collections.max(consonantMap.values());
        return vowelMaxFreq + consonantMaxFreq;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
