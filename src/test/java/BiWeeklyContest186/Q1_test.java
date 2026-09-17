package BiWeeklyContest186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1 q1 = new Q1();
        int[] nums = {1, 2, 3};
        boolean expectResult = true;
        boolean actualResult = q1.isMiddleElementUnique(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1 q1 = new Q1();
        int[] nums = {1, 2, 2};
        boolean expectResult = false;
        boolean actualResult = q1.isMiddleElementUnique(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
