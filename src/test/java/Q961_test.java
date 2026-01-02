import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q961_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q961 q961 = new Q961();
        int[] nums = {1, 2, 3, 3};
        int expectResult = 3;
        int actualResult = q961.repeatedNTimes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q961 q961 = new Q961();
        int[] nums = {2, 1, 2, 5, 3, 2};
        int expectResult = 2;
        int actualResult = q961.repeatedNTimes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q961 q961 = new Q961();
        int[] nums = {5, 1, 5, 2, 5, 3, 5, 4};
        int expectResult = 5;
        int actualResult = q961.repeatedNTimes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
