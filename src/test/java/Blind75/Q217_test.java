package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q217_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q217 q217 = new Q217();
        int[] nums = {1, 2, 3, 1};
        boolean expectResult = true;
        boolean actualResult = q217.containsDuplicate(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q217 q217 = new Q217();
        int[] nums = {1, 2, 3, 4};
        boolean expectResult = false;
        boolean actualResult = q217.containsDuplicate(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
