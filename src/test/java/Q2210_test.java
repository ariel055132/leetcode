import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2210_test {
    @Test
    @DisplayName("test case 1")
    void testCase1_Q2210() {
        Q2210 q2210 = new Q2210();
        int[] nums = {2, 4, 1, 1, 6, 5};
        int expectedResult = 3;
        int actualResult = q2210.countHillValleys(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("test case 2")
    void testCase2_Q2210() {
        Q2210 q2210 = new Q2210();
        int[] nums = {6, 6, 5, 5, 4, 1};
        int expectedResult = 0;
        int actualResult = q2210.countHillValleys(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
