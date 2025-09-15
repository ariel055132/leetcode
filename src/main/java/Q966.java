import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        // Exact Match (Case-sensitive)
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordlist));
        // Case-Insensitive
        HashMap<String, String> lowerCaseMap = new HashMap<>();
        // Vowel Errors
        HashMap<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            String lowerCaseWord = word.toLowerCase();
            lowerCaseMap.putIfAbsent(lowerCaseWord, word);
            String vowelWord = lowerCaseWord.replaceAll("[aeiou]", "#");
            vowelErrorMap.putIfAbsent(vowelWord, word);
        }

        for (int i = 0; i < queries.length; i++) {
            if (wordSet.contains(queries[i])) {
                result[i] = queries[i];
                continue;
            }
            String queryLower = queries[i].toLowerCase();
            String vowelWord = queryLower.replaceAll("[aeiou]", "#");
            if (lowerCaseMap.containsKey(queryLower)) {
                result[i] = lowerCaseMap.get(queryLower);
            } else if (vowelErrorMap.containsKey(vowelWord)) {
                result[i] = vowelErrorMap.get(vowelWord);
            } else {
                result[i] = "";
            }
        }
        return result;
    }
}
