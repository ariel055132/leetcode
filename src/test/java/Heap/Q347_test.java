package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q347_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q347 q347 = new Q347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expectResult = {1, 2};
        int[] actualResult = q347.topKFrequent(nums, 2);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    // 2 4 5 8, 3
    // add 3: 8 5 4 3 2 -> 4
    // add 5: 8 5 5 4 3 2 -> 5
    // add 10: 10 8 5 5 4 3 2 -> 5
    // add 9: 10 9 8 5 5 4 3 2 -> 8
    // add 4: 10 9 8 5 5 4 4 3 2 -> 8
}
