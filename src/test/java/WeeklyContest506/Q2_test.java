package WeeklyContest506;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2 q2 = new Q2();
        int[] nums = {1, 2, 2, 1, 2, 3, 3, 3};
        int expectResult = 5;
        int actualResult = q2.getLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2 q2 = new Q2();
        int[] nums = {5, 5, 5, 5};
        int expectResult = 4;
        int actualResult = q2.getLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2 q2 = new Q2();
        int[] nums = {1, 2, 3, 4};
        int expectResult = 1;
        int actaulResult = q2.getLength(nums);
        Assertions.assertEquals(expectResult, actaulResult);
    }
}
