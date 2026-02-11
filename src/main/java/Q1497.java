import java.util.HashMap;
import java.util.Map;

public class Q1497 {
    public boolean canArrange(int[] arr, int k) {
        // Key: Module number, Value: Happen number
        Map<Integer, Integer> map = new HashMap<>();
        // 1. Calculate the remainder of each element in the array when divided by k
        // Store the frequency of each remainder in a hash map
        for (int num : arr) {
            // Remainder do this to ensure get correct module result
            int remainder = ((num % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0 )+1);
        }
        // Checking pa
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == 0) {
                if (value % 2 != 0) return false;
            } else {
                int anotherKey = k - key;
                int anotherValue = map.getOrDefault(anotherKey, 0);
                if (value != anotherValue) return false;
            }
        }
        return true;
    }
}
