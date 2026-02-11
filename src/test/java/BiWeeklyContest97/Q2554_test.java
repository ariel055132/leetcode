package BiWeeklyContest97;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2554_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2554 q2554 = new Q2554();
        int[] banned = {1, 6, 5};
        int n = 5;
        int maxSum = 6;
        int expectResult = 2;
        int actualResult = q2554.maxCount(banned, n, maxSum);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
