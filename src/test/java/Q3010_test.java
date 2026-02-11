import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3010_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3010 q3010 = new Q3010();
        int[] nums = {1, 2, 3, 12};
        int expectResult = 6;
        int actualResult = q3010.minimumCost(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3010 q3010 = new Q3010();
        int[] nums = {5, 4, 3};
        int expectResult = 12;
        int actualResult = q3010.minimumCost(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3010 q3010 = new Q3010();
        int[] nums = {10, 3, 1, 1};
        int expectResult = 12;
        int actualResult = q3010.minimumCost(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
