package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1358_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1358_Brute q1358_Brute = new Q1358_Brute();
        String s = "abc";
        int expectResult = 1;
        int actualResult = q1358_Brute.numberOfSubstrings(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1358_Brute q1358_Brute = new Q1358_Brute();
        String s = "aaacb";
        int expectResult = 3;
        int actualResult = q1358_Brute.numberOfSubstrings(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1358_Brute q1358_Brute = new Q1358_Brute();
        String s = "abcabc";
        int expectResult = 10;
        int actualResult = q1358_Brute.numberOfSubstrings(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
