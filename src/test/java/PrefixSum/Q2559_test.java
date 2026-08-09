package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2559_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2559 q2559 = new Q2559();
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] expectResult = {2, 3, 0};
        int[] actualResult = q2559.vowelStrings(words, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2559 q2559 = new Q2559();
        String[] words = {"a", "e", "i"};
        int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        int[] expectResult = {3, 2, 1};
        int[] actualResult = q2559.vowelStrings(words, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
