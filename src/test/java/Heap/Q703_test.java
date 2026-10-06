package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q703_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        Q703 q703 = new Q703(k, nums);
        int expectResult1 = 4;
        int actualResult1 = q703.add(3);
        Assertions.assertEquals(expectResult1, actualResult1);
        int expectResult2 = 5;
        int actualResult2 = q703.add(5);
        Assertions.assertEquals(expectResult2, actualResult2);
    }
}
