package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2233_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2233 q2233 = new Q2233();
        int[] nums = {0, 4};
        int k = 5;
        int expectResult = 20;
        int actualResult = q2233.maximumProduct(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2233 q2233 = new Q2233();
        int[] nums = {6, 3, 3, 2};
        int k = 2;
        int expectResult = 216;
        int actualResult = q2233.maximumProduct(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
