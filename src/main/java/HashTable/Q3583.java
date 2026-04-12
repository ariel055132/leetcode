package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q3583 {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> suffix = new HashMap<>();
        for (int num : nums) {
            suffix.put(num, suffix.getOrDefault(num, 0)+1);
        }

        long result = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for (int num : nums) {
            suffix.put(num, suffix.getOrDefault(suffix, null) - 1);
            prefix.put(num, prefix.getOrDefault(prefix, 0) + 1);
            result += (long) prefix.getOrDefault(num * 2, 0) + (long) suffix.getOrDefault(num * 2, 0);
        }

        return (int) (result % MOD);
    }
}
