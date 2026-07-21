package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3427_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3427 q3427 = new Q3427();
        int[] nums = {2, 3, 1};
        int expectResult = 11;
        int actualResult = q3427.subarraySum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1 Prefix Sum")
    void test1PrefixSum() {
        Q3427 q3427 = new Q3427();
        int[] nums = {2, 3, 1};
        int expectResult = 11;
        int actualResult = q3427.subArraySum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2 Prefix Sum")
    void test2PrefixSum() {
        Q3427 q3427 = new Q3427();
        int[] nums = {3, 1, 1, 2};
        int expectResult = 13;
        int actualResult = q3427.subArraySum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
