package TwoPointers;

import TwoPointers.Q611;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q611_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q611 q611 = new Q611();
        int[] nums = {2, 2, 3, 4};
        int expectResult = 3;
        int actualResult = q611.triangleNumber(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q611 q611 = new Q611();
        int[] nums = {4, 2, 3, 4};
        int expectResult = 4;
        int actualResult = q611.triangleNumber(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
