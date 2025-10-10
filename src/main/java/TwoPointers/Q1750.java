package TwoPointers;

public class Q1750 {
    /**
     * Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
     * 1. Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
     * 2. Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
     * 3. The prefix and the suffix should not intersect at any index.
     * 4. The characters from the prefix and suffix must be the same.
     * 5. Delete both the prefix and the suffix.
     *
     * @param s String
     * @return right - left + 1
     */
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            // Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
            // The characters from the prefix and suffix must be the same.
            while (left <= right && currentChar == s.charAt(left)) {
                // Delete both the prefix and the suffix (by moving the index)
                left++;
            }
            // Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
            // The characters from the prefix and suffix must be the same.
            while (left <= right && currentChar == s.charAt(right)) {
                // Delete both the prefix and the suffix (by moving the index)
                right--;
            }
        }
        return  right - left + 1;
    }
}
