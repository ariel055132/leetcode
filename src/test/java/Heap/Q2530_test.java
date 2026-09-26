package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2530_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2530 q2530 = new Q2530();
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        long expectResult = 50;
        long actualResult = q2530.maxKelements(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
