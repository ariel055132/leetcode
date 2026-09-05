package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q974_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q974 q974 = new Q974();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expectResult = 7;
        int actualResult = q974.subarraysDivByK(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q974 q974 = new Q974();
        int[] nums = {5};
        int k = 9;
        int expectResult = 0;
        int actualResult = q974.subarraysDivByK(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test PrefixSum 1")
    void testPrefix() {
        Q974PrefixSum q974PrefixSum = new Q974PrefixSum();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expectResult = 7;
        int actualResult = q974PrefixSum.subarraysDivByK(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
