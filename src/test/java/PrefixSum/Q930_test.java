package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q930_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q930 q930 = new Q930();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int expectResult = 4;
        int actualResult = q930.numSubarraysWithSum(nums, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q930 q930 = new Q930();
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int expectResult = 15;
        int actualResult = q930.numSubarraysWithSum(nums, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test PrefixSum 1")
    void testPrefixSum1() {
        Q930PrefixSum q930PrefixSum = new Q930PrefixSum();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int expectResult = 4;
        int actualResult = q930PrefixSum.numSubarraysWithSum(nums, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test PrefixSum 2")
    void testPrefixSum2() {
        Q930PrefixSum q930PrefixSum = new Q930PrefixSum();
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int expectResult = 15;
        int actualResult = q930PrefixSum.numSubarraysWithSum(nums, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
