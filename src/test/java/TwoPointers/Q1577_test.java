package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1577_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1577 q1577 = new Q1577();
        int[] nums1 = {7, 4};
        int[] nums2 = {5, 2, 8, 9};
        int expectResult = 1;
        int actualResult = q1577.numTriplets(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1577 q1577 = new Q1577();
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1, 1};
        int expectResult = 9;
        int actualResult = q1577.numTriplets(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Follow Up")
    void testFol1() {
        Q1577_followUp followUp = new Q1577_followUp();
        int[] nums1 = {7, 4};
        int[] nums2 = {5, 2, 8, 9};
        int expectResult = 1;
        int actualResult = followUp.numTriplets(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Hidden Case")
    void testHidden() {
        Q1577_followUp followUp = new Q1577_followUp();

    }
}
