package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1962_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1962 q1962 = new Q1962();
        int[] piles = {5, 4, 9};
        int k = 2;
        int expectResult = 12;
        int actualResult = q1962.minStoneSum(piles, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
