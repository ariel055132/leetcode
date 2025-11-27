import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q259_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q259 q259 = new Q259();
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int expectResult = 2;
        int actualResult = q259.threeSumSmaller(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q259 q259 = new Q259();
        int[] nums = {};
        int target = 0;
        int expectResult = 0;
        int actualResult = q259.threeSumSmaller(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q259 q259 = new Q259();
        int[] nums = {0};
        int target = 0;
        int expectResult = 0;
        int actualResult = q259.threeSumSmaller(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
