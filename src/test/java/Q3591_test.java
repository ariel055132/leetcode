import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3591_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q3591 q3591 = new Q3591();
        int[] nums = {1, 2, 3, 4, 5, 4};
        boolean actualResult = q3591.checkPrimeFrequency(nums);
        boolean expectedResult = true; // 4 appears twice, which is prime
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q3591 q3591 = new Q3591();
        int[] nums = {1, 2, 3, 4, 5};
        boolean actualResult = q3591.checkPrimeFrequency(nums);
        boolean expectedResult = false; // All frequencies are 1, which is not prime
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q3591 q3591 = new Q3591();
        int[] nums = {2, 2, 2, 4, 4};
        boolean actualResult = q3591.checkPrimeFrequency(nums);
        boolean expectedResult = true; // 2 appears three times, which is prime
        Assertions.assertEquals(actualResult, expectedResult);
    }
}
