import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 */

public class Q1461 {
    public boolean hasAllCodes(String s, int k) {
        // Number of result = 2^k, where k is length given by question
        int result = (int) Math.pow(2, k);
        // Saving the substring and avoid duplication.
        Set<String> existString = new HashSet<>();
        // Traverse the string, i <= s.length() in order to make sure that the last character is traversed.
        for (int i = k; i <= s.length(); i++) {
            String currentString = s.substring(i - k, i);
            if (!existString.contains(currentString)) {
                existString.add(currentString);
                result--;
                // If result == 0, that means every binary code of length k is a substring in s, therefore return true
                if (result == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
