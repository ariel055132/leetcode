public class Q3461 {
    /**
     * You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
     *
     * For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
     * Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
     *
     * @param s String
     * @return Whether the final two digits in s are the same
     */
    public boolean hasSameDigits(String s) {
        while (s.length() != 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int firstDigit = s.charAt(i - 1) - '0';
                int secondDigit = s.charAt(i) - '0';
                int newDigit = (firstDigit + secondDigit) % 10;
                sb.append(newDigit);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
