import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2958_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q2958 q2958 = new Q2958();
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        int expectResult = 6;
        int actualResult = q2958.maxSubarrayLength(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q2958 q2958 = new Q2958();
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
        int k = 1;
        int expectResult = 2;
        int actualResult = q2958.maxSubarrayLength(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q2958 q2958 = new Q2958();
        int[] nums = {5, 5, 5, 5, 5, 5, 5};
        int k = 4;
        int expectResult = 4;
        int actualResult = q2958.maxSubarrayLength(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
