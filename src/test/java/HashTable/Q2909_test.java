package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2909_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2909 q2909 = new Q2909();
        int[] nums = {8, 6, 1, 5, 3};
        int expectResult = 9; // 1 + 5 + 3
        /**
         * map will have two pairs of key values as follows
         * map = {3:1+5=6; 4:1+3=4}
         * rightPart = 3 -> nums[nums.length-1], nums.length-1 == 4
         * nums[nums.length-2(3)] == 5
         * Result = map.get(3) + rightPart -> 9
         */
        int actualResult = q2909.minimumSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2909 q2909 = new Q2909();
        int[] nums = {5, 4, 8, 7, 10, 2};
        int expectResult = 13; // 4 + 7 + 2
        int actualResult = q2909.minimumSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2909 q2909 = new Q2909();
        int[] nums = {6, 5, 4, 3, 4, 5};
        int expectResult = -1;
        int acutalResult = q2909.minimumSum(nums);
        Assertions.assertEquals(expectResult, acutalResult);
    }
}
