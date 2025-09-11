import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2785 {
    /**
     *
     * 1. Collect the vowels in string s
     * 2. Sort the vowels
     * 3. Traverse the string again
     * 3.1. When the char is vowel, change it from step 2.
     *
     * @param s
     * @return
     */
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);
        int vowelsIndex = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                stringBuilder.append(vowels.get(vowelsIndex));
                vowelsIndex++;
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
