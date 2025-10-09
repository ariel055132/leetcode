package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q345_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q345 q345 = new Q345();
        String s = "IceCreAm";
        String expectResult = "AceCreIm";
        String actualResult = q345.reverseVowels(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q345 q345 = new Q345();
        String s = "leetcode";
        String expectRseult = "leotcede";
        String actualResult = q345.reverseVowels(s);
        Assertions.assertEquals(expectRseult, actualResult);
    }
}
