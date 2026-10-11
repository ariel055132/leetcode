package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3275_test {
    /**
     * queries/obstacles   distance  remove if size > 2     heap
     * [1, 2]                3              -               {3}
     * [3, 4]                7              -               {7,3}
     * [2, 3]                5              7               {5,3}
     * [-3, 0]               3 (abs)        5               {3,3}
     */
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3275 q3275 = new Q3275();
        int[][] queries = {{1, 2}, {3, 4}, {2, 3}, {-3, 0}};
        int k = 2;
        int[] expectResult = {-1, 7, 5, 3};
        int[] actualResult = q3275.resultArray(queries, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
