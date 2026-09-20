package HashTable;

import java.util.HashMap;

public class Q3498 {
    HashMap<Character, Integer> map = new HashMap<>();

    /**
     * Given a string s, calculate its reverse degree.
     * The reverse degree is calculated as follows:
     * 1. For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
     * 2. Sum these products for all characters in the string.
     * Return the reverse degree of s.
     * 
     * @param s
     * @return
     */
    public int reverseDegree(String s) {
        init();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // reads the current character.
            int idx = i + 1; // position in the string (1-indexed)
            int chVal = map.get(ch); // retrieves the character’s reversed alphabet value.
            result += idx * chVal; // sum products with idx and chVal
        }

        return result;
    }

    /**
     * fills the HashMap with the 26 letter values.
     */
    void init() {
        map.put('a', 26);
        map.put('b', 25);
        map.put('c', 24);
        map.put('d', 23);
        map.put('e', 22);
        map.put('f', 21);
        map.put('g', 20);
        map.put('h', 19);
        map.put('i', 18);
        map.put('j', 17);
        map.put('k', 16);
        map.put('l', 15);
        map.put('m', 14);
        map.put('n', 13);
        map.put('o', 12);
        map.put('p', 11);
        map.put('q', 10);
        map.put('r', 9);
        map.put('s', 8);
        map.put('t', 7);
        map.put('u', 6);
        map.put('v', 5);
        map.put('w', 4);
        map.put('x', 3);
        map.put('y', 2);
        map.put('z', 1);
    }
}
