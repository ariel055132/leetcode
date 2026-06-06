package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1167_test {
    /**
     * Start with sticks {2, 4, 3}
     * 1. Combine stick 2 and stick 3, cost = 2 + 3 = 5, sticks updated as {4, 5}
     * 2. Combine stick 4 and stick 5, cost = 4 + 5 = 9, sticks updated as {9} -> stop combine
     * 3. Calculate cost = 5 + 9 = 14
     */
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1167 q1167 = new Q1167();
        int[] sticks = {2, 4, 3};
        int expectResult = 14;
        int actualResult = q1167.connectSticks(sticks);
        Assertions.assertEquals(expectResult, actualResult);
    }

    /**
     * Start with sticks {1, 8, 3, 5}
     * 1. Combine stick 1 and stick 3, cost = 1 + 3 = 4, sticks updated as {4, 5, 8}
     * 2. Combine stick 4 and stick 5, cost = 4 + 5 = 9, sticks updated as {8, 9}
     * 3. Combine stick 8 and stick 9, cost = 8 + 9 = 17, sticks updated as {17} -> stop combine
     * 4. Calculate cost = 4 + 9 + 17 = 30
     */
    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1167 q1167 = new Q1167();
        int[] sticks = {1, 8, 3, 5};
        int expectResult = 30;
        int actualResult = q1167.connectSticks(sticks);
        Assertions.assertEquals(expectResult, actualResult);
    }

    /**
     * only one stick 5, cannot combine
     * Just return 0
     */
    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1167 q1167 = new Q1167();
        int[] sticks = {5};
        int expectResult = 0;
        int actualResult = q1167.connectSticks(sticks);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
