package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1081_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1081 q1081 = new Q1081();
        String s = "bcabc";
        String expectResult = "abc";
        String actualResult = q1081.smallestSubsequqnce(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2") 
    void test2() {
        Q1081 q1081 = new Q1081();
        String s = "bcaacdcbc";
        String expectResult = "acdb";
        String actualResult = q1081.smallestSubsequqnce(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
