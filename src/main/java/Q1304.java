public class Q1304 {
    /**
     * Given an integer n, return any array containing n unique integers such that they add up to 0.
     * If n is even, the final element should be zero
     * element should like 1, -1, 2, -2, .... , (0)
     *
     * @param n Length of array
     * @return the array with n length add up to 0
     */
    public int[] subZero(int n) {
        int[] result = new int[n];
        int j = 0;
        for (int i = 1; i <= n/2; i++) {
            result[j] = i;
            result[j + 1] = -i;
            j = j + 2;
        }
        return result;
    }
}
