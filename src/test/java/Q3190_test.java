import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3190_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3190 q3190 = new Q3190();
        int[] nums = {1, 2, 3, 4};
        int expectResult = 3;
        int actualResult = q3190.minimumOperation(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3190 q3190 = new Q3190();
        int[] nums = {3, 6, 9};
        int expectResult = 0;
        int actualResult = q3190.minimumOperation(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
