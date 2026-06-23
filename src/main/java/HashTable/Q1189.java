package HashTable;

import java.util.HashMap;

public class Q1189 {
    /**
     * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
     * You can use each character in text at most once. Return the maximum number of instances that can be formed.
     * 
     * Use a hashmap to store the frequencies of b, a, l, o, n
     * Find the smallest value of b, a, l, o, n in hashmap
     * Note: l, o need to divide by 2 as balloon.
     * 
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } 
        }
        return Math.min(
            Math.min(map.getOrDefault('b', 0), map.getOrDefault('a', 0)),
            Math.min(
            Math.min(map.getOrDefault('l', 0) / 2, map.getOrDefault('o', 0) / 2),
                    map.getOrDefault('n', 0)
    )
);
    }
}
