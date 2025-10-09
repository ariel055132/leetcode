package TwoPointers;

public class Q125 {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * @param s String
     * @return s is palindrome or not
     */
    public boolean isPalindrome(String s) {
        // Trim all the space and convert all uppercase letters to lowercase letter
       s = s.trim().toLowerCase();
       // If string is null, it is palindrome
        if (s == null) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            char leftLetter = s.charAt(left);
            char rightLetter = s.charAt(right);
            if (leftLetter != rightLetter) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
