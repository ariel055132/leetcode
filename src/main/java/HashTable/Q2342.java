package HashTable;
import java.util.HashMap;
import java.util.Map;

public class Q2342 {
    public int maximumSum(int[] nums) {
        // 1. Set up result for return, default MIN_VALUE for update
        int result = Integer.MIN_VALUE;
        // 2. Create a map
        // Key: Sum of digits of the number; Value: Sum of number with same digits
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = 0;
            int tmpNum = num;
            // 3. Find the sum of digits of the number with while loop
            while (tmpNum != 0) {
                key += tmpNum % 10;
                tmpNum /= 10;
            }
            //
            if (!map.containsKey(key)) {
                map.put(key, num);
            } else {
                int previousMax = map.get(key);
                int currentValue = previousMax + num;
                result = Math.max(result, currentValue);
                map.put(key, Math.max(num, previousMax));
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
