package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3478_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3478_TLE q3478 = new Q3478_TLE();
        int[] nums1 = {4, 2, 1, 5, 3};
        int[] nums2 = {10, 20, 30, 40, 50};
        int k = 2;
        long[] expectResult = {80, 30, 0, 80, 50};
        long[] actualResult = q3478.findMaxSum(nums1, nums2, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3478_TLE q3478 = new Q3478_TLE();
        int[] nums1 = {2, 2, 2, 2};
        int[] nums2 = {3, 1, 2, 3};
        int k = 1;
        long[] expectResult = {0, 0, 0, 0};
        long[] actualResult = q3478.findMaxSum(nums1, nums2, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
