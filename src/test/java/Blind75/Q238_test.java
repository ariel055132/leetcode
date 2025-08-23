package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q238_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q238 q238 = new Q238();
        int[] nums = {1, 2, 3, 4};
        int[] expectResult = {24, 12, 8, 6};
        int[] actualResult = q238.productExceptSelf(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q238 q238 = new Q238();
        int[] nums = {-1, -1, 0, -3, 3};
        int[] expectResult = {0, 0, 9, 0, 0};
        int[] actualResult = q238.productExceptSelf(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
