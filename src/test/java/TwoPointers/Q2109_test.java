package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2109_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2109 q2109 = new Q2109();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        String expectResult = "Leetcode Helps Me Learn";
        String actualResult = q2109.addSpaces(s, spaces);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
