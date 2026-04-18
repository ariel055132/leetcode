package HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q734 {
    /**
     * Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
     * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
     * 
     * Two sentences are similar if:
     * 1. They have the same length (i.e., the same number of words)
     * 2. sentence1[i] and sentence2[i] are similar.
     * Notice that a word is always similar to itself, also notice that the similarity relation is not transitive. For example, if the words a and b are similar, and the words b and c are similar, a and c are not necessarily similar.
     * 
     * @param sentence1
     * @param sentence2
     * @param similarPairs
     * @return
     */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            map.put(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            String p1 = sentence1[i];
            String p2 = sentence2[i];

            // Same word, always similar
            if (p1.equals(p2)) continue;
            // List all the situation that return false.
            if (!map.containsKey(p1) && !map.containsKey(p2)) return false;
            if (map.containsKey(p1) && !map.get(p1).equals(p2)) return false;
            if (map.containsKey(p2) && !map.get(p2).equals(p1)) return false;
        }
        // If above wrong situtations are passed, just return true
        return true;
    }
}
