import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3005_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3005 q3005 = new Q3005();
        int[] nums = {1, 2, 2, 3, 1, 4};
        int expectResult = 4;
        int actualResult = q3005.maxFrequencyElements(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3005 q3005 = new Q3005();
        int[] nums = {1, 2, 3, 4, 5};
        int expectResult = 5;
        int actualResult = q3005.maxFrequencyElements(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
