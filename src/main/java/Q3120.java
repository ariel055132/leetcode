import java.util.HashSet;
import java.util.Set;

public class Q3120 {
    /**
     * You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
     * Return the number of special letters in word.
     * 
     * Store all characters in a hash set.
     * Iterate from 'a' to 'z' and get each letter's uppercase form.
     * Check whether both the lowercase and uppercase letters exist in the set.
     * If both exist, increment result.
     * 
     * @param word String
     * @return result int
     */
    public int numberOfSpecialChars(String word) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            set.add(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char upperCh = Character.toUpperCase(ch);
            if (set.contains(ch) && set.contains(upperCh)) {
                result++;
            }
        }

        return result;
    }
}
