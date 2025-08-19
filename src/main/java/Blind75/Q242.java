package Blind75;

import java.util.Arrays;
import java.util.HashMap;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0 && t.length() == 0) return true;

        HashMap<Character, Integer> sHashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sHashMap.put(c, sHashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!sHashMap.containsKey(c)) {
                return false;
            } else {
                sHashMap.put(c, sHashMap.get(c) - 1);
                if (sHashMap.get(c) == 0) {
                    sHashMap.remove(c);
                }
            }
        }
        return sHashMap.isEmpty();
    }

    /**
     * Convert the two Strings into Arrays and sort them
     * Compare them, if they are equal, return true
     * Otherwise, return false
     *
     * @param s String
     * @param t String
     * @return isAnagram boolean
     */
    public boolean isAnagram1(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }
}
