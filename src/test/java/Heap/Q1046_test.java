package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1046_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1046 q1046 = new Q1046();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int expectResult = 1;
        int actualResult = q1046.lastStoneWeight(stones);
        Assertions.assertEquals(expectResult, actualResult);
    }    

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1046 q1046 = new Q1046();
        int[] stones = {1};
        int expectResult = 1;
        int actualResult = q1046.lastStoneWeight(stones);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
