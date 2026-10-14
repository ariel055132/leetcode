package Greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3723_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3723 q3723 = new Q3723();
        int num = 2;
        int sum = 3;
        String expectResult = "30";
        String actualResult = q3723.maxSumOfSquares(num, sum);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3723 q3723 = new Q3723();
        int num = 2;
        int sum = 17;
        String expectResult = "98";
        String actualResult = q3723.maxSumOfSquares(num, sum);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3723 q3723 = new Q3723();
        int num = 1;
        int sum = 10;
        String expectResult = "";
        String actualResult = q3723.maxSumOfSquares(num, sum);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
