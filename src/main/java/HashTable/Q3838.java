package HashTable;

import java.util.HashMap;

public class Q3838 {
    /**
     * You are given an array of strings words, where each string represents a word containing lowercase English letters.
     * You are also given an integer array weights of length 26, where weights[i] represents the weight of the ith lowercase English letter.
     * The weight of a word is defined as the sum of the weights of its characters.
     * For each word, take its weight modulo 26 and map the result to a lowercase English letter using reverse alphabetical order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
     * Return a string formed by concatenating the mapped characters for all words in order.
     * 
     * @param words
     * @param weights
     * @return
     */
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        // Create hashmap
        // Key: character; Value: weights of the character
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            map.put(ch, weights[i]);
        }
        for (String word : words) {
            // Take the weight from the previous hashmap and calculate each word's weights
            int sum = 0;
            for (char ch : word.toCharArray()) {
                sum += map.get(ch);
            }
            // Total weights modulo 26
            int mod = sum % 26;
            // Map the result to a lowercase English letter using reverse alphabetical order
            char ch = (char) ('z' - mod);
            result.append(ch);
        }

        return result.toString();
    }
}
