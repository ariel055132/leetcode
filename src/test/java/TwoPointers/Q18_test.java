package TwoPointers;

import TwoPointers.Q18;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q18_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q18 q18 = new Q18();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> expectresult = new ArrayList<>();
        expectresult.add(List.of(-2, -1, 1, 2));
        expectresult.add(List.of(-2, 0, 0, 2));
        expectresult.add(List.of(-1, 0, 0, 1));
        List<List<Integer>> actualresult = q18.fourSum(nums, target);
        Assertions.assertEquals(new HashSet<>(expectresult), new HashSet<>(actualresult));
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q18 q18 = new Q18();
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> expectResult = new ArrayList<>();
        expectResult.add(List.of(2, 2, 2, 2));
        List<List<Integer>> actualResult = q18.fourSum(nums, target);
        Assertions.assertEquals(new HashSet<>(actualResult), new HashSet<>(expectResult));
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q18 q18 = new Q18();
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> expectResult = new ArrayList<>();
        List<List<Integer>> actualResult = q18.fourSum(nums, target);
        Assertions.assertEquals(new HashSet<>(expectResult), new HashSet<>(actualResult));
    }
}
