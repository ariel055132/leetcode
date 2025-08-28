package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2529_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q2529 q2529 = new Q2529();
        int[] nums = {-2, -1, -1, 1, 2, 3};
        int expectResult = 3;
        int actualResult = q2529.maximumCount(nums);
        System.out.println(q2529.binarySearch(nums, 0));
        System.out.println(q2529.binarySearch(nums, 1));
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q2529 q2529 = new Q2529();
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        int expectResult = 3;
        int actualResult = q2529.maximumCount(nums);
        System.out.println(q2529.binarySearch(nums, 0));
        System.out.println(q2529.binarySearch(nums, 1));
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q2529 q2529 = new Q2529();
        int[] nums = {5, 20, 66, 1314};
        int expectResult = 4;
        int actualResult = q2529.maximumCount(nums);
        System.out.println(q2529.binarySearch(nums, 0));
        System.out.println(q2529.binarySearch(nums, 1));
        Assertions.assertEquals(expectResult, actualResult);
    }
}
