package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q35_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q35 q35 = new Q35();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expectResult = 2;
        int actualResult = q35.searchInsert(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q35 q35 = new Q35();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expectResult = 1;
        int actualResult = q35.searchInsert(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Case 3")
    void test3() {
        Q35 q35 = new Q35();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expectResult = 4;
        int actualResult = q35.searchInsert(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
