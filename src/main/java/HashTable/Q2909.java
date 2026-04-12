package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q2909 {
    public int minimumSum(int[] nums) {
        // Minimum possible sum of a mountain triplet of nums
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        // Left Part of the nums
        int minValueLeftPart = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minValueLeftPart = Math.min(minValueLeftPart, nums[i-1]);
            if (nums[i] > minValueLeftPart) {
                map.put(i, minValueLeftPart + nums[i]);
            }
        }
        // Right Part of the nums
        int minValueRightPart = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            minValueRightPart = Math.min(minValueRightPart, nums[i+1]);
            if (nums[i] > minValueRightPart && map.containsKey(i)) {
                // Sum -> (minValueLeftPart + nums[i] -> from map) + minValueRightPart 
                int currentResult = map.get(i) + minValueRightPart;
                result = Math.min(result, currentResult);
            }
        }
        
        // If triplet not found, return -1. Otherwise return result
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
