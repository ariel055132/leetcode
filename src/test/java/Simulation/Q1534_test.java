package Simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1534_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1534 q1534 = new Q1534();
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;
        int expectResult = 4;
        int actualResult = q1534.countGoodTriplets(arr, a, b, c);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1534 q1534 = new Q1534();
        int[] arr = {1, 1, 2, 2, 3};
        int a = 0;
        int b = 0;
        int c = 1;
        int expectResult = 0;
        int actualResult = q1534.countGoodTriplets(arr, a, b, c);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
