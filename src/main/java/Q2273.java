import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char[] prevWord = words[i-1].toCharArray();
            char[] currWord = words[i].toCharArray();
            Arrays.sort(prevWord);
            Arrays.sort(currWord);
            if (!Arrays.equals(prevWord, currWord)) {
                result.add(words[i]);
            }
        }

        return result;
    }
}
