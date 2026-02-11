package BiWeeklyContest97;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2553_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2553 q2553 = new Q2553();
        int[] nums = {13, 25, 83, 77};
        int[] expectResult = {1, 3, 2, 5, 8, 3, 7, 7};
        int[] actualResult = q2553.separateDigits(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
