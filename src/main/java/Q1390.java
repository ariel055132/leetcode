import java.util.ArrayList;
import java.util.List;

public class Q1390 {
    /**
     * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
     * If there is no such integer in the array, return 0.
     *
     * @param nums int[]
     * @return int
     */
    public int sumFourDivisors(int[] nums) {
        int result = 0; // result for return
        for (int num : nums) {
            List<Integer> numDivisors = new ArrayList<>();
            for (int i = 1; i * i <= num ; i++) {
                if (num % i == 0) {
                    numDivisors.add(i);
                    // Some example may have sqrt, such as 9 -> 1, 3, 9 (3*3 == 9) need to prevent this situation (double added to list)
                    if (i != num / i) {
                        numDivisors.add(num / i);
                    }
                }
                // If divisors size are greater than 4, break
                if (numDivisors.size() > 4) break;
            }
            if (numDivisors.size() == 4) {
                for (int k : numDivisors) {
                    result += k;
                }
            }
        }
        return result;
    }
}
