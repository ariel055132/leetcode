package BiWeeklyContest186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2 q2 = new Q2();
        int[] nums = {1, 3, 5, 2, 8};
        int k = 2;
        int expectResult = 13;
        int actualResult = q2.maxValidPairSum(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2 q2 = new Q2();
        int[] nums = {5, 1, 9};
        int k = 1;
        int expectResult = 14;
        int actualResult = q2.maxValidPairSum(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
