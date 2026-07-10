import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q288 {
    /**
     * The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and last letter, and its last letter. 
     * If a word has only two characters, then it is an abbreviation of itself.
     * For example:
     * 1. dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
     * 2. internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
     * 3. it --> it because any word with only two characters is an abbreviation of itself.
     */

    /**
     * Construct map
     * Key: Abbreviation of word
     * Value: the word that have the same abbreviation of word
     */
    Map<String, Set<String>> map = new HashMap<>();
    /**
     * Implement the Q288 (ValidWordAbbr class)
     * Initializes the object with a dictionary of words.
     * @param dictionary
     */
    public Q288(String[] dictionary) {
        for (String str : dictionary) {
            String abbreviation = toAbbreviation(str);
            if (map.containsKey(abbreviation)) {
                Set<String> set = map.get(abbreviation);
                set.add(str);
                map.put(abbreviation, set);
            } else {
                Set<String> set = new HashSet<>();
                set.add(str);
                map.put(abbreviation, set);
            }
        }
    }
    
    /**
     * Returns true if either of the following conditions are met (otherwise returns false): 
     * 1. There is no word in dictionary whose abbreviation is equal to word's abbreviation.
     * 2. For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
     * 
     * @param word
     * @return
     */
    public boolean isUnique(String word) {
        String abbreviation = toAbbreviation(word);
        // No word in dictionary whose abbreviation is equal to word's abbreviation
        if (!map.containsKey(abbreviation) || abbreviation.isBlank()) {
            return true;
        } else {
            // If the only dictionary word with that abbreviation is the query word itself -> return true
            // Otherwise, return false
            return map.get(abbreviation).size() == 1 && map.get(abbreviation).contains(word);
        }
    }

    /**
     * Turn string to abbreviation form
     * @param s
     * @return
     */
    public String toAbbreviation(String s) {
        int sLen = s.length();
        if (s.length() <= 2) return s;
        return s.charAt(0) + Integer.toString(sLen - 2)  + s.charAt(sLen - 1);
    }
}
