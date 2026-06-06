import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2574_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2574 q2574 = new Q2574();
        int[] nums = {10, 4, 8, 3};
        int[] expectResult = {15, 1, 11, 22};
        int[] actualResult = q2574.leftRightDifference(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2574 q2574 = new Q2574();
        int[] nums = {1};
        int[] expectResult = {0};
        int[] actualResult = q2574.leftRightDifference(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
