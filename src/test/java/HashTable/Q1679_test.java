package HashTable;

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
        int actualRseult = q1679.maxOperations(nums, k);
        Assertions.assertEquals(expectResult, actualRseult);
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

    @Test
    @DisplayName("Hidden Test Case")
    void test3() {
        Q1679 q1679 = new Q1679();
        int[] nums = {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k = 3;
        int expectResult = 4;
        int actualResult = q1679.maxOperations(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
