package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q704_test {
    @Test
    @DisplayName("Example 1")
    void testExample1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Q704 q704 = new Q704();
        int actualResult = q704.search(nums, target);
        int expectResult = 4;
        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    @DisplayName("Example 2")
    void testExample2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        Q704 q704 = new Q704();
        int expectResult = -1;
        int actualResult = q704.search(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Edge Case")
    void testExample3() {
        int[] nums = {5};
        int target = 5;
        Q704 q704 = new Q704();
        int expectResult = 0;
        int actualResult = q704.search(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Case")
    void testExample4() {
        int[] nums = {2, 5};
        int target = 5;
        Q704 q704 = new Q704();
        int expectResult = 1;
        int actualResult = q704.search(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
