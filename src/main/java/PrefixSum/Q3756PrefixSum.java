package PrefixSum;

public class Q3756PrefixSum {
    private static final long MOD = 1_000_000_007L;

    /**
     * precompute prefix information so every query takes O(1) time.
     * 
     * @param s
     * @param queries
     * @return
     */

    public int[] sumAndMultiply(String s, int[][] queries) {
        
        // Number formed from the first k characters after removing zeros, modulo MOD
        long[] val = new long[s.length() + 1];
        // 10^k % MOD
        long[] pow10 = new long[s.length() + 1];
        pow10[0] = 1;
        // Number of nonzero digits in the first k characters
        int[] count = new int[s.length() + 1];
        // Sum of all digits in the first k characters
        int[] prefixSumDigit = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            pow10[i + 1] = pow10[i] * 10 % MOD;
            count[i + 1] = count[i] + (ch == 0 ? 0 : 1);
            if (ch == 0) {
                val[i + 1] = val[i];
            } else {
                val[i + 1] = (val[i] * 10 + ch) % MOD;
            }
            prefixSumDigit[i + 1] = prefixSumDigit[i] + ch;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            int len = count[right + 1] - count[left];
            long x = val[right + 1] - val[left] * pow10[len] % MOD; 
            x = (x + MOD) % MOD;
            long digitSum = prefixSumDigit[right + 1] - prefixSumDigit[left];

            result[i] = (int) (x * digitSum % MOD);
        }

        return result;
    }
}
