import java.util.HashMap;
import java.util.Map;

public class Q1056 {
    public boolean confusingNumber(int n) {
        if (n == 0) return false;
        int originalN = n;
        Map<Integer, Integer> rotateDigitMap = new HashMap<>();
        rotateDigitMap.put(0, 0);
        rotateDigitMap.put(1, 1);
        rotateDigitMap.put(6, 9);
        rotateDigitMap.put(8, 8);
        rotateDigitMap.put(9, 6);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int digit = n % 10;
            if (!rotateDigitMap.containsKey(digit)) {
                return false;
            }
            sb.append(rotateDigitMap.get(digit));
            n /= 10;
        }
        int rotateN = Integer.parseInt(sb.toString());
        return rotateN != originalN;
    }
}
