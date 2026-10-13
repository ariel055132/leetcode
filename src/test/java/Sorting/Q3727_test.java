package Sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3727_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3727 q3727 = new Q3727();
        int[] nums = {1, 2, 3};
        long expectResult = 12;
        long actualResult = q3727.maxAlternatingSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3727 q3727 = new Q3727();
        int[] nums = {1, -1, 2, -2, 3, -3};
        long expectResult = 16;
        long actualResult = q3727.maxAlternatingSum(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
