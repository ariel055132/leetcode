package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3264_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3264 q3264 = new Q3264();
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] expectResult = {8, 4, 6, 5, 6};
        int[] actualResult = q3264.getFinalState(nums, k, multiplier);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3264 q3264 = new Q3264();
        int[] nums = {1, 2};
        int k = 3;
        int multiplier = 4;
        int[] expectResult = {16, 8};
        int[] actualResult = q3264.getFinalState(nums, k, multiplier);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
