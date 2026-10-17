package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q3583 {
    /**
     *
     * @param nums
     * @return
     */
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> suffix = new HashMap<>();
        for (int num : nums) {
            suffix.put(num, suffix.getOrDefault(num, 0)+1);
        }

        long result = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for (int num : nums) {
            suffix.put(num, suffix.getOrDefault(num, 0) - 1);
            result += (long) prefix.getOrDefault(num * 2, 0) * (long) suffix.getOrDefault(num * 2, 0);
            prefix.put(num, prefix.getOrDefault(num, 0) + 1);
        }

        return (int) (result % MOD);
    }

    /**
     * Brute Force Approach
     * Tries every combination of three indices
     *
     * @param nums int[]
     * @return
     */
    public int specialTripletsBrute(int[] nums) {
        long count = 0;
        // i < j < k
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == 2 * nums[j] && nums[k] == 2 * nums[j]) {
                        count++;
                    }
                }
            }
        }
        return (int) count % 1_000_000_007;
    }
}
