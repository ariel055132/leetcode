package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2558_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2558 q2558 = new Q2558();
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        long expectResult = 29;
        long actualResult = q2558.pickGifts(gifts, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q2558 q2558 = new Q2558();
        int[] gifts = {1, 1, 1, 1};
        int k = 4;
        long expectResult = 4;
        long actualResult = q2558.pickGifts(gifts, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
