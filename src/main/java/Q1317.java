public class Q1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int b = n - i;
            if (!String.valueOf(i).contains("0") && !String.valueOf(b).contains("0")) {
                return new int[]{i, b};
            }
        }
        return new int[]{};
    }
}
