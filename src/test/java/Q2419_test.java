import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2419_test {
    @Test
    @DisplayName("Test Case 1")
    void testCase1_Q2419() {
        Q2419 q2419 = new Q2419();
        int[] nums = {1, 2, 3, 3, 2, 2};
        int expectedResult = 2;
        int actualResult = q2419.longestSubArray(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void testCase2_Q2419() {
        Q2419 q2419 = new Q2419();
        int[] nums = {1, 1, 1, 1, 1};
        int expectedResult = 5;
        int actualResult = q2419.longestSubArray(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 3")
    void testCase3_Q2419() {
        Q2419 q2419 = new Q2419();
        int[] nums = {1, 2, 3, 4};
        int expectedResult = 1;
        int actualResult = q2419.longestSubArray(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
