package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q347_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q347 q347 = new Q347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expectResult = {2, 1};
        int[] actualResult = q347.topKFrequent(nums, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q347 q347 = new Q347();
        int[] nums = {7, 7};
        int k = 1;
        int[] expectResult = {7};
        int[] actualResult = q347.topKFrequent(nums, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
