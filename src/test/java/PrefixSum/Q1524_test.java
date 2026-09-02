package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1524_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1524 q1524 = new Q1524();
        int[] arr = {1, 3, 5};
        int expectResult = 4;
        int actualResult = q1524.numOfSubarrays(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1524 q1524 = new Q1524();
        int[] arr = {2, 4, 6};
        int expectResult = 0;
        int actualResult = q1524.numOfSubarrays(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1524 q1524 = new Q1524();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int expectResult = 16;
        int actualResult = q1524.numOfSubarrays(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("PrefixSum Test 1")
    void prefixSumTest1() {
        Q1524PrefixSum q1524 = new Q1524PrefixSum();
        int[] arr = {1, 3, 5};
        int expectResult = 4;
        int actualResult = q1524.numOfSubarrays(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("PrefixSum Test 2")
    void prefixSumTest2() {
        Q1524PrefixSum q1524 = new Q1524PrefixSum();
        int[] arr = {2, 4, 6};
        int expectResult = 0;
        int actualResult = q1524.numOfSubarrays(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
