package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q34_test {
    @Test
    @DisplayName("Test Search Left index equal to target")
    void testSearchLeftIndex_Example1() {
        Q34 q34 = new Q34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int expectLeftIndex = 3;
        int actualLeftIndex = q34.searchLeftIndex(nums, target);
        Assertions.assertEquals(expectLeftIndex, actualLeftIndex);
    }

    @Test
    @DisplayName("Test Search Right Index equal to target")
    void testSearchRightIndex_Example1() {
        Q34 q34 = new Q34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int expectRightIndex = 4;
        int actualRightIndex = q34.searchRightIndex(nums, target);
        Assertions.assertEquals(expectRightIndex, actualRightIndex);
    }

    @Test
    @DisplayName("Test Example 1")
    void test1() {
        Q34 q34 = new Q34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expectResult = {3, 4};
        int[] actualResult = q34.searchRange(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Example 2")
    void test2() {
        Q34 q34 = new Q34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expectResult = {-1, -1};
        int[] actualResult = q34.searchRange(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Example 3")
    void test3() {
        Q34 q34 = new Q34();
        int[] nums = {};
        int target = 0;
        int[] expectResult = {-1, -1};
        int[] actualResult = q34.searchRange(nums, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
