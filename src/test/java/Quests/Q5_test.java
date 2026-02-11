package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q5_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q5 q5 = new Q5();
        int[] nums = {8, 1, 2, 2, 3};
        int[] expectResult = {4, 0, 1, 1, 3};
        int[] actualResult = q5.smallerNumbersThanCurrent(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
