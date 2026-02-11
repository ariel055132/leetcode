import java.util.HashMap;
import java.util.Map;

public class Q1234 {
    public int balancedString(String s) {
        int balancedNum = s.length() / 4;
        boolean allBalanced = true;
        int result = s.length(); // set this to the length of string s as it need to return the min return result
        HashMap<Character, Integer> sFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            sFreqMap.put(c, sFreqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : sFreqMap.entrySet()) {
            Character character = entry.getKey();
            Integer value = entry.getValue();
            if (value != balancedNum) {
                allBalanced = false;
                break;
            }
        }

        // No need to implement replace, return 0
        if (allBalanced) {
            return 0;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character currentChar = s.charAt(right);
            sFreqMap.put(currentChar, sFreqMap.get(currentChar) - 1);
            while (sFreqMap.get('Q') <= balancedNum && sFreqMap.get('W') <= balancedNum &&
                    sFreqMap.get('E') <= balancedNum && sFreqMap.get('R') <= balancedNum) {
                result = Math.min(result, right - left + 1);
                int cnt = sFreqMap.get(s.charAt(left));
                sFreqMap.put(s.charAt(left), ++cnt);
                left++;
            }
        }
        return result;
    }
}
