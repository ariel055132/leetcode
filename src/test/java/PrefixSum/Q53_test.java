package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q53_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q53 q53 = new Q53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expectResult = 6;
        int actualResult = q53.maxSubArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q53 q53 = new Q53();
        int[] nums = {1};
        int expectResult = 1;
        int actualResult = q53.maxSubArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q53 q53 = new Q53();
        int[] nums = {5, 4, -1, 7, 8};
        int expectResult = 23;
        int actualResult = q53.maxSubArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Prefix Test 1")
    void test1_PrefixSum() {
        Q53PrefixSum q53PrefixSum = new Q53PrefixSum();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expectResult = 6;
        int actualResult = q53PrefixSum.maxSubArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Prefix Hidden Test")
    void hiddenTest_PrefixSum() {
        Q53PrefixSum q53PrefixSum = new Q53PrefixSum();
        int[] nums = {-2};
        int expectResult = -2;
        int actualResult = q53PrefixSum.maxSubArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
