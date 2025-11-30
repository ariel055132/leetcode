import java.util.HashMap;
import java.util.Map;

public class Q2815 {
    public int maxSum(int[] nums) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            // maxDigit get the rotation of nums
            if (map.containsKey(maxDigit)) {
                // update result
                result = Math.max(result, num + map.get(maxDigit));
            }
            map.put(maxDigit, num);
        }
        return result;
    }

    private int getMaxDigit(int num) {
        int maxD = 0;
        while (num > 0) {
            maxD = Math.max(maxD, num % 10);
            num /= 10;
        }
        return maxD;
    }
}
