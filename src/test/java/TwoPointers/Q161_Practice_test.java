package TwoPointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Q161_Practice_test {
    @Test
    @DisplayName("Test Case 1")
    void test1() {
        Q161_Practice q161 = new Q161_Practice();
        String s = "ab";
        String t = "acb";
        boolean expectResult = true;
        boolean actualResult = q161.isOneEditDistance(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void test2() {
        Q161_Practice q161 = new Q161_Practice();
        String s = "";
        String t = "";
        boolean expectResult = false;
        boolean actualResult = q161.isOneEditDistance(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 3")
    void test3() {
        Q161_Practice q161 = new Q161_Practice();
        String s = "a";
        String t = "a";
        boolean expectResult = false;
        boolean actualResult = q161.isOneEditDistance(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
