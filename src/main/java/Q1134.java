public class Q1134 {
    public int armstrongCalculation(int n, int k) {
        int result = 0;
        while (n != 0) {
            int tmp = n % 10;
            result += Math.pow(tmp, k);
            n /= 10;
        }
        return result;
    }

    /**
     * Given an integer n, return true if and only if it is an Armstrong number
     * The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
     * 
     * For example: 153 -> 1^3 + 5^3 + 3^3
     * 2 -> 2^1
     * 
     * Just simulate, and kth pow is the length of n
     * @param n
     * @return
     */
    public boolean isArmstrong(int n) {
        int nLen = String.valueOf(n).length();
        int result = armstrongCalculation(n, nLen);
        return result == n;
    }
}
