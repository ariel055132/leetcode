import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1390_test {
    @Test
    @DisplayName("Test Case 1")
    void test1() {
        Q1390 q1390 = new Q1390();
        int[] nums = {21, 4, 7};
        int expectResult = 32;
        int actualResult = q1390.sumFourDivisors(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void test2() {
        Q1390 q1390 = new Q1390();
        int[] nums = {21, 21};
        int expectResult = 64;
        int actualResult = q1390.sumFourDivisors(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 3")
    void test3() {
        Q1390 q1390 = new Q1390();
        int[] nums = {1, 2, 3, 4, 5};
        int expectResult = 0;
        int actualResult = q1390.sumFourDivisors(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
