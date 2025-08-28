package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2300_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q2300 q2300 = new Q2300();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;
        int[] expectResult = {4, 0, 3};
        int[] actualResult = q2300.successfulPairs(spells, potions, success);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q2300 q2300 = new Q2300();
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        int success = 16;
        int[] expectResult = {2, 0, 2};
        int[] actualResult = q2300.successfulPairs(spells, potions, success);
        Assertions.assertArrayEquals(actualResult, expectResult);
    }
}
