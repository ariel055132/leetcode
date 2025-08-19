package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q242_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q242 q242 = new Q242();
        String s = "anagram";
        String t = "nagaram";
        boolean expectResult = true;
        boolean actualResult = q242.isAnagram1(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
