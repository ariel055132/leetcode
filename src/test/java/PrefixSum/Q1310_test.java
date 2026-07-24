package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1310_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1310 q1310 = new Q1310();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] expectResult = {2, 7, 14, 8};
        int[] actualResult = q1310.xorQueries(arr, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1310 q1310 = new Q1310();
        int[] arr = {4, 8, 2, 10};
        int[][] queries = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] expectResult = {8, 0, 4, 4};
        int[] actualResult = q1310.xorQueries(arr, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);    
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1310PrefixSum q1310PrefixSum = new Q1310PrefixSum();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] expectResult = {2, 7, 14, 8};
        int[] actualResult = q1310PrefixSum.xorQueries(arr, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
