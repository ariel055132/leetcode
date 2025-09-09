import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2824_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2824 q2824 = new Q2824();
        List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
        int target = 2;
        int expectResult = 3;
        int actualResult = q2824.countPairs(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1")
    void test2() {
        Q2824 q2824 = new Q2824();
        List<Integer> nums = new ArrayList<>(Arrays.asList(-6, 2, 5, -2, -7, -1, 3));
        int target = -2;
        int expectResult = 10;
        int actualResult = q2824.countPairs(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
