package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3532_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3532 q3532 = new Q3532();
        int n = 2;
        int[] nums = {1, 3};
        int maxDiff = 1;
        int[][] queries = {{0, 0}, {0, 1}};
        boolean[] expectResult = {true, false};
        boolean[] actualResult = q3532.pathExistenceQueries(n, nums, maxDiff, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3532 q3532 = new Q3532();
        int n = 4;
        int[] nums = {2, 5, 6, 8};
        int maxDiff = 2;
        int[][] queries = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        boolean[] expectResult = {false, false, true, true};
        boolean[] actualResult = q3532.pathExistenceQueries(n, nums, maxDiff, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
