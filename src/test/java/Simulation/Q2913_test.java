package Simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q2913_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2913 q2913 = new Q2913();
        List<Integer> nums = Arrays.asList(1, 2, 1);
        int expectResult = 15;
        int actualResult = q2913.sumCounts(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2913 q2913 = new Q2913();
        List<Integer> nums = Arrays.asList(1, 1);
        int expectResult = 3;
        int actualResult = q2913.sumCounts(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
