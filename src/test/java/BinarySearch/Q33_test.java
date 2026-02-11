package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q33_test {
    @Test
    @DisplayName("Test Case 1")
    void test1() {
        Q33 q33 = new Q33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expectResult = 4;
        int actualResult = q33.search(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
