package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2563_BruteForce_test {
    @Test
    @DisplayName("Test Case 1")
    void test1() {
        Q2563_BruteForce q2563BruteForce = new Q2563_BruteForce();
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        long expectResult = 6;
        long actualResult = q2563BruteForce.countFairPairs(nums, lower, upper);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void test2() {
        Q2563_BruteForce q2563BruteForce = new Q2563_BruteForce();
        int[] nums = {1, 7, 9, 2, 5};
        int lower = 11;
        int upper = 11;
        long expectResult = 1;
        long actualResult = q2563BruteForce.countFairPairs(nums, lower, upper);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
