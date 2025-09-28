import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q976_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q976 q976 = new Q976();
        int[] nums = {2, 1, 2};
        int expectResult = 5;
        int actualResult = q976.largestPerimeter(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q976 q976 = new Q976();
        int[] nums = {1, 2, 1, 10};
        int expectResult = 0;
        int actualResult = q976.largestPerimeter(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
