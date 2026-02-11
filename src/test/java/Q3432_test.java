import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3432_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3432 q3432 = new Q3432();
        int[] nums = {10, 10, 3, 7, 6};
        int expectResult = 4;
        int actualResult = q3432.countPartitions(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3432 q3432 = new Q3432();
        int[] nums = {1, 2, 2};
        int expectResult = 0;
        int actualResult = q3432.countPartitions(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
