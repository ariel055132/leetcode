package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2336_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2336 q2336 = new Q2336();
        q2336.addBack(2);
        int num = q2336.popSmallest();
        int expectResult = 1;
        Assertions.assertEquals(expectResult, num);
    }
}
