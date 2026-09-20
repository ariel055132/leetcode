package SlidingWindow;

public class Q2904 {
    /**
     * You are given a binary string s and a positive integer k.
     * A substring of s is beautiful if the number of 1's in it is exactly k.
     * Let len be the length of the shortest beautiful substring.
     * Return the lexicographically smallest beautiful substring of string s with length equal to len. If s doesn't contain a beautiful substring, return an empty string.
     * A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b.
     * For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
     * 
     * @param s
     * @param k
     * @return
     */
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            String tmp = "";
            int len = 0;
            // Count the number of 1
            int countOne = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                tmp += ch;
                if (ch == '1') {
                    countOne++;
                }
                // New substring length
                len = j - i + 1;
                // If the number of 1 equals to k, need to compare the substring with the exist substring
                if (countOne == k) {
                    if (minimum > len) {
                        minimum = len;
                        result = tmp;
                    } else if (minimum == len && tmp.compareTo(result) < 0) {
                        // A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b.
                        // use compareTo to do the comparison
                        result = tmp;
                    }
                }

            }
        }

        return result;
    }
}
