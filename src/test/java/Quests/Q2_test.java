package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2 q2 = new Q2();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] expectResult = {2, 3, 5, 4, 1, 7};
        int[] actualResult = q2.shuffle(nums, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2 q2 = new Q2();
        int[] nums = {1,2,3,4,4,3,2,1};
        int n = 4;
        int[] expectResult = {1,4,2,3,3,2,4,1};
        int[] actualResult = q2.shuffle(nums, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2 q2 = new Q2();
        int[] nums = {1,1,2,2};
        int n = 2;
        int[] expectResult = {1, 2, 1, 2};
        int[] actualResult = q2.shuffle(nums, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
