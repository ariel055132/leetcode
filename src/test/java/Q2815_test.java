import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2815_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2815 q2815 = new Q2815();
        int[] nums = {112, 131, 411};
        int expectResult = -1;
        int actualResult = q2815.maxSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2815 q2815 = new Q2815();
        int[] nums = {2536, 1613, 3366, 162};
        int expectResult = 5902;
        int actualResult = q2815.maxSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
