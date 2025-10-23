package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2540_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2540 q2540 = new Q2540();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        int expectResult = 2;
        int actualResult = q2540.getCommon(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2540 q2540 = new Q2540();
        int[] nums1 = {1, 2, 3, 6};
        int[] nums2 = {2, 3, 4, 5};
        int expectResult = 2;
        int actualResult = q2540.getCommon(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
