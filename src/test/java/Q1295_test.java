import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1295_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1295 q1295 = new Q1295();
        int[] nums = {12, 345, 2, 6, 7896};
        int expectResult = 2;
        int actualResult = q1295.findNumbers(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1295 q1295 = new Q1295();
        int[] nums = {555, 901, 482, 1771};
        int expectResult = 1;
        int actualResult = q1295.findNumbers(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
