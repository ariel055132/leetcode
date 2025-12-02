package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1679_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1679 q1679 = new Q1679();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int expectResult = 2;
        int actualResult = q1679.maxOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1679 q1679 = new Q1679();
        int[] nums = {3, 1, 3, 4, 4};
        int k = 6;
        int expectResult = 1;
        int actualResult = q1679.maxOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
