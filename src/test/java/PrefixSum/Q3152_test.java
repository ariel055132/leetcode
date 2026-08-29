package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3152_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3152PrefixSum q3152 = new Q3152PrefixSum();
        int[] nums = {3, 4, 1, 2, 6};
        int[][] queries = {{0, 4}};
        boolean[] expectResult = {false};
        boolean[] actualResult = q3152.isArraySpecial(nums, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
