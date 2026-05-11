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

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2553 q2553 = new Q2553();
        int[] nums = {7, 1, 3, 9};
        int[] expectResult = {7, 1, 3, 9};
        int[] actualResult = q2553.separateDigits(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2553 q2553 = new Q2553();
        int[] nums = {10921};
        int[] expectResult = {1, 0, 9, 2, 1};
        int[] actualResult = q2553.separateDigits(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
