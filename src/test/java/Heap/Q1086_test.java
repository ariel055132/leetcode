package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1086_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1086 q1086 = new Q1086();
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] expectResult = {{1, 87}, {2, 88}};
        int[][] result = q1086.highFive(items);
        Assertions.assertArrayEquals(expectResult, result);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1086 q1086 = new Q1086();
        int[][] items = {{1,100}, {7,100}, {1,100}, {7,100}, {1,100}, {7,100}, {1,100}, {7,100}, {1,100}, {7,100}};
        int[][] expectResult = {{1, 100}, {7, 100}};
        int[][] actualResult = q1086.highFive(items);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
