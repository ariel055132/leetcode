    /**
     * Given a character array s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
     * Your code must solve the problem in-place, i.e. without allocating extra space.
     */
public class Q186 {
    public void reverseWords(char[] s) {
        /**
         * Reverse the whole array
         * Example: t h e  s k y  i s  b l u e
         * ->.      e u l b  s i  y k s  e h t  
         */
        reverse(s, 0, s.length - 1);
        /**
         * Start reverse the words inside the array one by one
         * Example: e u l b  s i  y k s  e h t  
         * ->.      b l u e  i s  s k y  e h t 
         */
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        /**
         * Reverse the last word
         * Example: b l u e  i s  s k y  e h t 
         * ->.      b l u e  i s  s k y  t h e
         */
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
