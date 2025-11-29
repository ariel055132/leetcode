import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3512_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3512 q3512 = new Q3512();
        int[] nums = {3, 9, 7};
        int k = 5;
        int expectResult = 4;
        int actualResult = q3512.minOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3512 q3512 = new Q3512();
        int[] nums = {4, 1, 3};
        int k = 4;
        int expectResult = 0;
        int actualResult = q3512.minOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3512 q3512 = new Q3512();
        int[] nums = {3, 2};
        int k = 6;
        int expectResult = 5;
        int actualResult = q3512.minOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
