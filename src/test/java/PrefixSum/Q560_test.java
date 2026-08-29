package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q560_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q560 q560 = new Q560();
        int[] nums = {1, 1, 1};
        int k = 2;
        int expectResult = 2;
        int actualResult = q560.subarraySum(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q560 q560 = new Q560();
        int[] nums = {1, 2, 3};
        int k = 3;
        int expectResult = 2;
        int actualResult = q560.subarraySum(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test PrefixSum")
    void test1PrefixSum() {
        Q560PrefixSum q560 = new Q560PrefixSum();
        int[] nums = {1, 1, -1, 1, -1};
        int k = 1;
        int expectResult = 6;
        int actualResult = q560.subarraySum(nums, k);
        Assertions.assertEquals(expectResult, actualResult);

    }
}
