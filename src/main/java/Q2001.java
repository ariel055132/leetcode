import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Q2001 {
    /**
     * 1. Create a HashMap to store the ratio (key) and frequency count of rectangles with that ratio (value)
     * 2. Traverse the rectangle array, check if ratio exist in map, count new pairs
     * pairs = map.get(ratio) - 1; result += pairs (as the current rectangle can pair with all previous rectangles having the same ratio)
     *
     * Time Complexity: O(n), single pass through all rectangles, HashMap operations
     * Space Complexity: O(n), use HashMap to store unique ratios
     *
     * @param rectangles
     * @return
     */
    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        Map<BigDecimal, Integer> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            BigDecimal ratio = BigDecimal.valueOf((double)rectangles[i][0] / rectangles[i][1]);
            if (map.get(ratio) == null) {
                map.put(ratio, 1);
            } else {
                map.put(ratio, map.get(ratio) + 1);
            }
            result += map.get(ratio) - 1;
        }
        return result;
    }
}
