package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q167_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q167 q167 = new Q167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expectResult = {1, 2};
        int[] actualResult = q167.twoSum(numbers, target);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
