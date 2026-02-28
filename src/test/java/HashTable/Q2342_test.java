package HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2342_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2342 q2342 = new Q2342();
        int[] nums = {18, 43, 36, 13, 7};
        int expectResult = 54;
        int actualResult = q2342.maximumSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2342 q2342 = new Q2342();
        int[] nums = {10, 12, 19, 14};
        int expectResult = -1;
        int actualResult = q2342.maximumSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2342 q2342 = new Q2342();
        int[] nums = {368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183};
        int expectResult = 835;
        int actualResult = q2342.maximumSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
