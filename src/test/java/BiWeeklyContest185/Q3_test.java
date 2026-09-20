package BiWeeklyContest185;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3 q3 = new Q3();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        int[] baseTime = {9, 5, 3};
        long expectResult = 17;
        long actualResult = q3.finishTime(n, edges, baseTime);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
