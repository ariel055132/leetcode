import java.util.HashMap;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        // Edge Case: Empty String, return 0
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int n = s.length();
        int left = 0;
        int result = 0; // return result
        HashMap<Character, Integer> charFreqMap = new HashMap();
        for (int right = 0; right < n; right++) {
            Character character = s.charAt(right);
            charFreqMap.put(character, charFreqMap.getOrDefault(character, 0) + 1);
            // Meet duplicated character in the string, move the left pointers
            while (charFreqMap.get(character) > 1) {
                /**
                 * Need to do the subtraction in hashmap?
                 * Y -> Otherwise cannot escape the while loop
                 * Use left index, otherwise cannot tackle case like pwwkew
                 */
                Character currentChar = s.charAt(left);
                int freq = charFreqMap.get(currentChar);
                charFreqMap.put(currentChar, --freq);
                left++;
            }
            result = Math.max(result, right - left + 1);

        }
        return result;
    }
}
