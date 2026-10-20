package HashTable;

import BiWeeklyContest185.Q1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1930_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1930 q1930 = new Q1930();
        String s = "aabca";
        int expectResult = 3;
        int actualResult = q1930.countPalindromicSubsequence(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1930 q1930 = new Q1930();
        String s = "adc";
        int expectResult = 0;
        int actualResult = q1930.countPalindromicSubsequence(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1930 q1930 = new Q1930();
        String s = "bbcbaba";
        int expectResult = 4;
        int actualResult = q1930.countPalindromicSubsequence(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1 (Brute)")
    void test1Brute() {
        Q1930 q1930 = new Q1930();
        String s = "aabca";
        int expectResult = 3;
        int actualResult = q1930.countPalindromicSubsequenceBrute(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2 (Brute)")
    void test2Brute() {
        Q1930 q1930 = new Q1930();
        String s = "adc";
        int expectResult = 0;
        int actualResult = q1930.countPalindromicSubsequenceBrute(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

}
