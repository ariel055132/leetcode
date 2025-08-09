package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q15_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q15 q15 = new Q15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        var result = q15.threeSum(nums);
        // Expected: [[-1,-1,2],[-1,0,1]]
        System.out.println(result);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q15 q15 = new Q15();
        int[] nums = {0, 1, 1};
        var result = q15.threeSum(nums);
        // Expected: []
        System.out.println(result);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q15 q15 = new Q15();
        int[] nums = {0, 0, 0};
        var result = q15.threeSum(nums);
        // Expected: [[0,0,0]]
        System.out.println(result);
    }

    @Test
    @DisplayName("Hidden Example")
    void exampleHidden() {
        Q15 q15 = new Q15();
        int[] nums = {-2, 0, 1, 1, 2};
        var result = q15.threeSum(nums);
        // Expected: [[-2,0,2],[-2,1,1]]
        System.out.println(result);
    }
}
