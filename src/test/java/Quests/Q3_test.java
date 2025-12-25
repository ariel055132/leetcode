package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3 q3 = new Q3();
        int[] nums = {1, 1, 0, 1, 1, 1};
        int expectResult = 3;
        int actualResult = q3.findMaxConsecutiveOnes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3 q3 = new Q3();
        int[] nums = {1, 1, 1, 1, 1, 1};
        int expectResult = 6;
        int actualResult = q3.findMaxConsecutiveOnes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3 q3 = new Q3();
        int[] nums = {0, 0, 0, 0, 0, 0};
        int expectResult = 0;
        int actualResult = q3.findMaxConsecutiveOnes(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
