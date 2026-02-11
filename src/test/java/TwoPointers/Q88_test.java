package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q88_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
       Q88 q88 = new Q88();
       int[] nums1 = {1, 2, 3, 0, 0, 0};
       int m = 3;
       int[] nums2 = {2, 5, 6};
       int n = 3;
       int[] expectResult = {1, 2, 2, 3, 5, 6};
       q88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expectResult, nums1);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q88 q88 = new Q88();
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expectResult = {1};
        q88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expectResult, nums1);
    }

    @Test
    @DisplayName("Test 1")
    void test3() {
        Q88 q88 = new Q88();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expectResult = {1};
        q88.merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expectResult, nums1);
    }
}
