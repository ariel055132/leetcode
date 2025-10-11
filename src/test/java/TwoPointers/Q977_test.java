package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q977_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q977 q977 = new Q977();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expectResult = {0, 1, 9, 16, 100};
        int[] actualResult = q977.sortedSquares(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1 FollowUp")
    void test1_FollowUp() {
        Q977_FollowUp followUp = new Q977_FollowUp();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expectResult = {0, 1, 9, 16, 100};
        int[] actualResult = followUp.sortedSquares(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2 FollowUp")
    void test2_FollowUp() {
        Q977_FollowUp followUp = new Q977_FollowUp();
        int[] nums = {-7, -3, 2, 3, 11};
        int[] expectResult = {4, 9, 9, 49, 121};
        int[] actualResult = followUp.sortedSquares(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
