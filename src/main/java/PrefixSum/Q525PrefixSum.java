package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Q525PrefixSum {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int[] prefixNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            if (nums[i] == 0) {
                num = -1;
            } else {
                num = 1;
            }
            prefixNums[i+1] = prefixNums[i] + num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixNums.length; i++) {
            int num = prefixNums[i];
            if (map.containsKey(num)) {
                result = Math.max(result, i - map.get(num));
            } else {
                map.put(num, i);
            }
        }

        return result;
    }
}
