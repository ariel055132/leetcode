public class Q326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }
}
