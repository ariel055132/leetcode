import java.util.HashMap;
import java.util.Map;

public class Q1056 {
    /**
     * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
     * We can rotate digits of a number by 180 degrees to form new digits.
     * When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
     * When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
     * 
     * Note that after rotating 
     * For example, original number is 1689, after rotation, it should be 6891
     * For example, after rorating 8000, we have 0008, which is considered as 8
     * Given an integer n, return true if it is a confusing number, or false otherwise.
     * 
     * Just use a map to store the rotation of digits.
     * Traverse the number, and obtain the rotated number
     * Return rotatedNumber == originalNumber
     * 
     * @param n
     * @return
     */
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
                // Invalid string, return false
                return false;
            }
            sb.append(rotateDigitMap.get(digit));
            n /= 10;
        }
        int rotateN = Integer.parseInt(sb.toString());
        return rotateN != originalN;
    }
}
