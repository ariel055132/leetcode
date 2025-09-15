import java.util.HashSet;
import java.util.Set;

public class Q1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int result = 0;
        // Use a set to save the broken letters (Characters)
        Set<Character> set = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }
        // flag
        boolean broken = false;
        // Traverse the text
        for (char ch : text.toCharArray()) {
            // Facing another character in text
            if (ch == ' ') {
                // If the current character does not contain the brokenLetter, result++
                if (!broken) result++;
                broken = false;
            } else {
                // If broken letter set contain the character in text, turn the flag to true
                if (set.contains(ch)) broken = true;
            }
        }
        return result += !broken ? 1 : 0;
    }
}
