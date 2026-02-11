import java.util.ArrayList;
import java.util.List;

public class Q2787 {
    public int numberOfWays(int n, int x) {
        int mod = 1000000007;
        // Precompute all powers i^x such that i^x <= n
        List<Integer> allNumbersResult = new ArrayList<>();
        for (int i = 1; i<= n; i++) {
            long iSquareValue = (long) Math.pow(i, x);
            if (iSquareValue > n) {
                break;
            }
            allNumbersResult.add((int) iSquareValue);
        }
        int[] powers = allNumbersResult.stream().mapToInt(Integer::intValue).toArray();
        int[][] dp = new int[powers.length][n + 1];

        /*
        for (int power : powers) {
            System.out.println(power);
        }

         */
        return 0;
    }
}
