package TwoPointers;

import TwoPointers.Q16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q16_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q16 q16 = new Q16();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int expectResult = 2;
        int actualResult = q16.threeSumClosest(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q16 q16 = new Q16();
        int[] nums = {0, 0, 0};
        int target = 1;
        int expectResult = 0;
        int actualResult = q16.threeSumClosest(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
