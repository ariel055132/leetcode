import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1979_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1979 q1979 = new Q1979();
        int[] nums = {2, 5, 6, 9, 10};
        int expectResult = 2;
        int actualResult = q1979.findGCD(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1979 q1979 = new Q1979();
        int[] nums = {7, 5, 6, 8, 3};
        int expectResult = 1;
        int actualResult = q1979.findGCD(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
