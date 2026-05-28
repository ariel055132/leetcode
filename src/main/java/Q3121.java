public class Q3121 {
    /**
     * You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.
     * Return the number of special letters in word
     * 
     * aaAbcBC -> return 3 [a (1) : A (2); b (3) : B (5); c (4) : C (6)]
     * abc -> return 0 (no uppercase letter)
     * AbBCab -> return 0 [a (4) : A (0); b (5) : B (2); c does not have upperletter]
     * 
     * @param word
     * @return
     */
    public int numberOfSpecialChars(String word) {
        int result = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char upperCh = Character.toUpperCase(ch);
            int lowerChLastIndex = word.lastIndexOf(ch);
            int upperChIndex = word.indexOf(upperCh);
            if (lowerChLastIndex != -1 && upperChIndex != -1 && lowerChLastIndex < upperChIndex) result++;
        }
        return result;
    }
}
