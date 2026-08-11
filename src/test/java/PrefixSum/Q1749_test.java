package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1749_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1749 q1749 = new Q1749();
        int[] nums = {1, -3, 2, 3, -4};
        int expectResult = 5;
        int actualResult = q1749.maxAbsoluteSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1749 q1749 = new Q1749();
        int[] nums = {2, -5, 1, -4, 3, -2};
        int expectResult = 8;
        int actualResult = q1749.maxAbsoluteSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
