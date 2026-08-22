public class Q3622 {
    /**
     * You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
     * The digit sum of n (the sum of its digits).
     * The digit product of n (the product of its digits).
     * Return true if n is divisible by this sum; otherwise, return false.
     * 
     * Just calculate the digit sum and digit product respectively.
     * Check out whether n is divisible by the sum of digit sum and digit product.
     * 
     * @param n
     * @return
     */
    public boolean checkDivisiblilty(int n) {
        int sumDigit = 0;
        int productDigit = 1;
        int num = n;

        while (num > 0) {
            int digit = num % 10;
            sumDigit += digit;
            productDigit *= digit;
            num /= 10;
        }

        return n % (sumDigit + productDigit) == 0;
    }
}
