package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q2824_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2824 q2824 = new Q2824();
        List<Integer> nums = List.of(-1, 1, 2, 3, 1);
        int target = 2;
        int expectResult = 3;
        int actualResult = q2824.countPairs(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
