import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q1403_test {
    @Test
    @DisplayName("Test Case 1")
    void testCase1_Q1403() {
        Q1403 q1403 = new Q1403();
        int[] nums = {4, 3, 10, 9, 8};
        List<Integer> expectedResult = Arrays.asList(10, 9);
        List<Integer> actualResult = q1403.minSubsequence(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void testCase2_Q1403() {
        Q1403 q1403 = new Q1403();
        int[] nums = {4, 4, 7, 6, 7};
        List<Integer> expectedResult = Arrays.asList(7, 7, 6);
        List<Integer> actualResult = q1403.minSubsequence(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
