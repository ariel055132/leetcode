package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1 q1 = new Q1();
        int[] nums = {1, 2, 1};
        int[] expectResult = {1, 2, 1, 1, 2, 1};
        int[] actualResult = q1.getConcatenation(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
