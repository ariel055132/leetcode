package PrefixSum;

public class Q3756 {
    /**
     * You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].
     * For each queries[i], extract the substring s[li..ri]. Then, perform the following:
     * Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
     * Let sum be the sum of digits in x. The answer is x * sum.
     * Return an array of integers answer where answer[i] is the answer to the ith query.
     * Since the answers may be very large, return them modulo 109 + 7.
     * 
     * Brute force
     * 
     */
    private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int idx = 0; idx < queries.length; idx++) {
            long x = 0;
            long sum = 0;
            int l = queries[idx][0];
            int r = queries[idx][1];
            for (int i = l; i <= r; i++) {
                int digit = s.charAt(i) - '0';
                if (digit != 0) {
                    x = (x * 10 + digit) % MOD;
                    sum += digit;
                }
            }
            result[idx] = (int) (x * sum % MOD);
        }
        return result;
    }

}
