package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q215_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q215 q215 = new Q215();
        /**
         * num=3:  heap=[3]                    size=1
         * num=2:  heap=[2,3]                  size=2
         * num=1:  heap=[1,2,3]                size=3
         * num=5:  heap=[1,2,3,5] → [2,3,5]    size=4, remove 1
         * num=6:  heap=[2,3,5,6] → [3,5,6]    size=4, remove 2
         * num=4:  heap=[3,4,5,6] → [4,5,6]    size=4, remove 3
         * Result: minHeap.peek() = 4  (3rd largest)
         */
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expectResult = 5;
        int actualResult = q215.findKthLargest(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q215 q215 = new Q215();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expectResult = 4;
        int actualResult = q215.findKthLargest(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
