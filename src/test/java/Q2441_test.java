import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2441_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2441 q2441 = new Q2441();
        int[] nums = {-1, 2, -3, 3};
        int expectResult = 3;
        int actualResult = q2441.findMaxK(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
