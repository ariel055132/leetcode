package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q167_Practice_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Q167_Practice q167 = new Q167_Practice();
        int[] expectResult = {1, 2};
        int[] actualResult = q167.twoSum(numbers, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
