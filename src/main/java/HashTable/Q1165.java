package HashTable;

import java.util.HashMap;

public class Q1165 {
    /**
     * There is a special keyboard with all keys in a single row.
     * Example: abcdefghijklmnopqrstuvwxyz
     * a -> 0, b -> 1, c -> 2, and so on
     * 
     * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25). Initially, your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
     * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
     * 
     * @param keyboard
     * @param word
     * @return
     */
    public int calculateTime(String keyboard, String word) {
        int currentWordIndex = 0;
        int result = 0;
        // Save the index of each character of special keyboard
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        // Traverse the word, and calculate the distance (aka. total time)
        for (int i = 0; i < word.length(); i++) {
            int currentValue = map.get(word.charAt(i));
            // Add the distance from previous index to current letter's index to the result
            int distance = Math.abs(currentValue - currentWordIndex);
            result += distance;
            // Update the previous index to current index for next iteration
            currentWordIndex = currentValue;
        }
        return result;
    }
}
