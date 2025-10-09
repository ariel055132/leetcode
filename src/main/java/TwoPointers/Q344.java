package TwoPointers;

public class Q344 {
    /**
     * Write a function that reverse a string.
     * The input string is given as an array of character s
     * Modifying the input array in-place with O(1) extra memory
     *
     * @param s char[]
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
