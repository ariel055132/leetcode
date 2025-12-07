public class Q1523_WA {
    /**
     *
     */
    public int countOdds(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}
