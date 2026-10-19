package ArrayScan;

import Stack.Q20;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q2089_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2089 q2089 = new Q2089();
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;
        List<Integer> expectResult = Arrays.asList(1, 2);
        List<Integer> actualResult = q2089.targetIndices(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2089 q2089 = new Q2089();
        int[] nums = {1, 2, 5, 2, 3};
        int target = 3;
        List<Integer> expectResult = Arrays.asList(3);
        List<Integer> actualResult = q2089.targetIndices(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2089 q2089 = new Q2089();
        int[] nums = {1, 2, 5, 2, 3};
        int target = 5;
        List<Integer> expectResult = Arrays.asList(4);
        List<Integer> actualResult = q2089.targetIndices(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
