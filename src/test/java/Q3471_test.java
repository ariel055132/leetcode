import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3471_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3471 q3471 = new Q3471();
        int[] nums = {3, 9, 2, 1, 7};
        int k = 3;
        int expectResult = 7;
        int actualResult = q3471.largestInteger(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3471 q3471 = new Q3471();
        int[] nums = {3, 9, 7, 2, 1, 7};
        int k = 4;
        int expectResult = 3;
        int actualResult = q3471.largestInteger(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
    
    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3471 q3471 = new Q3471();
        int[] nums = {0, 0};
        int k = 1;
        int expectResult = -1;
        int actualResult = q3471.largestInteger(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
