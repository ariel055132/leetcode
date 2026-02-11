import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3637_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3637 q3637 = new Q3637();
        int[] nums = {1, 3, 5, 4, 2, 6};
        boolean expectResult = true;
        boolean actualResult = q3637.isTrionic(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
