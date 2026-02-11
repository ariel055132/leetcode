import java.util.ArrayList;
import java.util.List;

public class Q2438 {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Long> powers = new ArrayList<>();
        // Create the powers table
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add((long) (1 << i));
            }
        }
        // Calculate the product for each query with powers
        int m = powers.size();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = (product * powers.get(j)) % mod;
            }
            result[i] = (int) product;
        }
        return result;
    }
}
