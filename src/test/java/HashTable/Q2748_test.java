package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2748_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2748 q2748 = new Q2748();
        int[] nums = {2, 5, 1, 4};
        int expectResult = 5;
        int actualResult = q2748.countBeautifulPairs(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2748 q2748 = new Q2748();
        int[] nums = {11, 21, 12};
        int expectResult = 2;
        int actualResult = q2748.countBeautifulPairs(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
