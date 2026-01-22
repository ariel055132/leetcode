package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q4_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q4 q4 = new Q4();
        int[] nums = {1, 2, 2, 4};
        int[] expectResult = {2, 3};
        int[] actualResult = q4.findErrorNums(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
