package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q633_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q633 q633 = new Q633();
        int c = 5;
        boolean expectResult = true;
        boolean actualResult = q633.judgeSquareSum(c);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q633 q633 = new Q633();
        int c = 3;
        boolean expectResult = false;
        boolean actualResult = q633.judgeSquareSum(c);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
