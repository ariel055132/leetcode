package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q153_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q153 q153 = new Q153();
        int[] nums = {3, 4, 5, 1, 2};
        int expectResult = 1;
        int actualResult = q153.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q153 q153 = new Q153();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int expectResult = 1;
        int actualResult = q153.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
