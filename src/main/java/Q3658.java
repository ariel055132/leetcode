public class Q3658 {
    /**
     * You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:
     * sumOdd: the sum of the smallest n positive odd numbers.
     * sumEven: the sum of the smallest n positive even numbers.
     * Return the GCD of sumOdd and sumEven.
     * 
     * arithmetic series formulas
     * sumOdd: 1 + 3 + ... + (2n-1) = n^2
     * sumEven: 2 + 4 + ... + 2n = n(n+1)
     * @param n
     * @return
     */
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n,  n * (n + 1));
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
