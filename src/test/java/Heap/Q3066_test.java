package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3066_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3066 q3066 = new Q3066();
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int expectResult = 2;
        int actualResult = q3066.minOpeations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3066 q3066 = new Q3066();
        int[] nums = {1, 1, 2, 4, 9};
        int k = 20;
        int expectResult = 4;
        int actualResult = q3066.minOpeations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void hiddenTest() {
        Q3066 q3066 = new Q3066();
        int[] nums = {999999999, 999999999, 999999999};
        int k = 1000000000;
        int expectResult = 2;
        int actualResult = q3066.minOpeations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
