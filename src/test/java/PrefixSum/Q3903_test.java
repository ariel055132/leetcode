package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3903_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3903 q3903 = new Q3903();
        int[] nums = {5, 0, 1, 4};
        int k = 3;
        int expectResult = 3;
        int actualResult = q3903.firstStableIndex(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3903 q3903 = new Q3903();
        int[] nums = {3, 2, 1};
        int k = 1;
        int expectResult = -1;
        int actualResult = q3903.firstStableIndex(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3903 q3903 = new Q3903();
        int[] nums = {0};
        int k = 0;
        int expectResult = 0;
        int actualResult = q3903.firstStableIndex(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
