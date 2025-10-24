package SlidingWindow;

import SlidingWindow.Q713;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q713_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q713 q713 = new Q713();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int actualResult = q713.numSubarrayProductLessThanK(nums, k);
        int expectResult = 8;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q713 q713 = new Q713();
        int[] nums = {1, 2, 3};
        int k = 0;
        int actualResult = q713.numSubarrayProductLessThanK(nums, k);
        int expectResult = 0;
        Assertions.assertEquals(expectResult, actualResult);
    }
}
