package Heap;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2208_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2208 q2208 = new Q2208();
        int[] nums = {5, 19, 8, 1};
        int expectResult = 3;
        int actualResult = q2208.halveArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2208 q2208 = new Q2208();
        int[] nums = {3, 8, 20};
        int expectResult = 3;
        int actualResult = q2208.halveArray(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
