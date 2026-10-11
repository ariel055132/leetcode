package Simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2778_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2778 q2778 = new Q2778();
        int[] nums = {1, 2, 3, 4};
        int expectResult = 21;
        int actualResult = q2778.sumOfSquares(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2778 q2778 = new Q2778();
        int[] nums = {2, 7, 1, 19, 18, 3};
        int expectResult = 63;
        int actualResult = q2778.sumOfSquares(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
