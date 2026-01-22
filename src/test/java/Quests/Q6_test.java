package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q6_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q6 q6 = new Q6();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expectResult = Arrays.asList(5, 6);
        List<Integer> actualResult = q6.findDisappearedNumbers(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
