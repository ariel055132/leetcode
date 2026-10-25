package HashTable;

public class Q2748 {
    /**
     * You are given a 0-indexed integer array nums. A pair of indices i, j where 0 <= i < j < nums.length is called beautiful if the first digit of nums[i] and the last digit of nums[j] are coprime.
     * Return the total number of beautiful pairs in nums.
     * Two integers x and y are coprime if there is no integer greater than 1 that divides both of them. In other words, x and y are coprime if gcd(x, y) == 1, where gcd(x, y) is the greatest common divisor of x and y.
     *
     * @param nums
     * @return
     */
    public int countBeautifulPairs(int[] nums) {
        int result = 0;
        // Visit every pair once
        // i selects the earlier number, and j selects a later number
        // Starting j at i + 1 ensures i < j, avoid pairing a number with itself, and prevents duplicate pairs
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int last = nums[j];
                // First digit: Divide the number by 10 until one digit is left
                int firstDigit = first;
                // Last digit: % 10
                int lastDigit = last % 10;
                while (first >= 10) {
                    firstDigit = first / 10;
                    first /= 10;
                }
                // Count the pair when its GCD is 1
                result += gcd(firstDigit, lastDigit) == 1 ? 1 : 0;
            }
        }

        return result;
    }

    /**
     * Euclidean algorithm
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
