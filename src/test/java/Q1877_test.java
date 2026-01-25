import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1877_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1877 q1877 = new Q1877();
        int[] nums = {3, 5, 2, 3};
        int expectResult = 7;
        int actualResult = q1877.minPairSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1877 q1877 = new Q1877();
        int[] nums = {3, 5, 4, 2, 4, 6};
        int expectResult = 8;
        int actualResult = q1877.minPairSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
