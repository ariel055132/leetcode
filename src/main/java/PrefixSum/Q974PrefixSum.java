package PrefixSum;

import java.util.HashMap;

public class Q974PrefixSum {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int[] prefixNums = new int[nums.length + 1];
        // map (key: remainder; values: number of previous prefix sums with that remainder)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Builds the prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixNums[i + 1] = prefixNums[i] + nums[i];
        }

        for (int num : prefixNums) {
            int remainder = ((num % k) + k) % k;
            result += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return result;
    }
}
