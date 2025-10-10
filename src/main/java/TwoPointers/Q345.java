package TwoPointers;

public class Q345 {
    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     * The vowels are 'a', 'e', 'i', 'o', 'u', and they can appear in both lower and upper cases, more than once.
     *
     * 1. Traverse the string from beginning and the end
     * 2. Determine the character is vowel or not
     * 3. If the character is vowel, do the swap
     * @param s String
     * @return reversed string
     */
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(s.charAt(left))) {
                left++;
            }
            while (left < right && !isVowel(s.charAt(right))) {
                right--;
            }
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c== 'E' || c== 'I' || c=='O' || c=='U' ) return true;
        return false;
    }
}
