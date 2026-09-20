package BiWeeklyContest186;

public class Q4 {
    private static final int MOD = 1_000_000_007;
    public int interleaveCharacters(String word1, String word2, String target) {
        int result = 0;
        long[][] table = new long[word1.length()+1][word2.length()+1];
        table[0][0] = 1;
        for (char targetCh : target.toCharArray()) {
            long[][] next = new long[word1.length()+1][word2.length()+1];

            // Select word1[i - 1]; keep word2's last position fixed.
            for (int j = 0; j <= word2.length(); j++) {
                long prefixSum = 0;
                for (int i = 1; i <= word1.length(); i++) {
                    prefixSum = (prefixSum + table[i-1][j]) % MOD;
                    if (word1.charAt(i - 1) == targetCh) {
                        next[i][j] = (next[i][j] + prefixSum) % MOD;
                    }
                }
            }

            // Select word2[j - 1]; keep word1's last position fixed.
            for (int i = 0; i <= word1.length(); i++) {
                long prefixSum = 0;
                for (int j = 1; j <= word2.length(); j++) {
                    prefixSum = (prefixSum + table[i][j-1]) % MOD;
                    if (word2.charAt(j-1) == targetCh) {
                        next[i][j] = (next[i][j] + prefixSum) % MOD;
                    }
                }
            }

            table = next;
        }   
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                result = (int)(result + table[i][j]) % MOD;
            }
        }

        return result;
    }
}
