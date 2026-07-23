package PrefixSum;

public class Q2559 {
    /**
     * You are given a 0-indexed array of strings words and a 2D array of integers queries.
     * Each query queries[i] = [li, ri] asks us to find the number of strings present at the indices ranging from li to ri (both inclusive) of words that start and end with a vowel.
     * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
     * 
     * 
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        // vowel[i] is true when words[i] starts and ends with a vowel.
        boolean[] vowel = new boolean[words.length];

        // vowelPrefix[i] stores the number of valid words in indices [0, i).
        // The extra leading element lets us answer ranges that start at index 0.
        int[] vowelPrefix = new int[words.length + 1];
        int[] result = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (stringStartAndEndWithVowel(word)) {
                vowel[i] = true;
            } else {
                vowel[i] = false;
            }
        }
        for (int i = 0; i < vowel.length; i++) {
            boolean isVowel = vowel[i];
            int count = vowelPrefix[i];
            if (isVowel) {
                vowelPrefix[i + 1] = count + 1;
            } else {
                vowelPrefix[i + 1] = count + 0;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // Remove the count before start from the count through end.
            result[i] = vowelPrefix[end + 1] - vowelPrefix[start];
        }
        return result;
    }

    /**
     * Determine whether the string starts and ends with a vowel.
     * 
     * @param word
     * @return
     */
    public boolean stringStartAndEndWithVowel(String word) {
        char firstChar = word.charAt(0);
        char finalChar = word.charAt(word.length() - 1);

        if (isVowel(finalChar) && isVowel(firstChar)) {
            return true;
        }
        return false;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}
