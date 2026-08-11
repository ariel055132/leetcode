package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2996_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2996 q2996 = new Q2996();
        int[] nums = {1, 2, 3, 2, 5};
        int expectResult = 6;
        int actualResult = q2996.missingInteger(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2996 q2996 = new Q2996();
        int[] nums = {3, 4, 5, 1, 12, 14, 13};
        int expectResult = 15;
        int actualResult = q2996.missingInteger(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
