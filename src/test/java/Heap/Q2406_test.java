package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2406_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2406 q2406 = new Q2406();
        int[][] intervals = {{5, 10},{6, 8}, {1, 5}, {2, 3}, {1, 10}};
        int expectResult = 3;
        int actualResult = q2406.minGroups(intervals);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
