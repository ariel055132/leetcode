public class Q231 {
    public boolean isPowerOfTwo(int num) {
        while (num != 0) {
            if (num == 1) {
                return true;
            }
            else if (num % 2 != 0) {
                return false;
            }
            num /= 2;
        }
        return false;
    }
}
