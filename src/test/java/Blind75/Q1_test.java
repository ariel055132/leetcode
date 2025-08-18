package Blind75;

import Blind75.Q1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q1 q1 = new Q1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectResult = {0, 1};
        int[] actualResult = q1.twoSum(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q1 q1 = new Q1();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expectResult = {1, 2};
        int[] actualResult = q1.twoSum(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q1 q1 = new Q1();
        int[] nums = {3, 3};
        int target = 6;
        int[] expectResult = {0, 1};
        int[] actualResult = q1.twoSumHashMap(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
