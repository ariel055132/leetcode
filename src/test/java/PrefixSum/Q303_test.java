package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q303_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Q303 q303 = new Q303(nums);
        Assertions.assertEquals(1, q303.sumRange(0, 2));
        Assertions.assertEquals(-1, q303.sumRange(2, 5));
        Assertions.assertEquals(-3, q303.sumRange(0, 5));
    }
} 
