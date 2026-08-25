package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3718_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3718 q3718 = new Q3718();
        int[] nums = {8, 2, 3, 4, 6};
        int k = 2;
        int expectResult = 10;
        int actualResult = q3718.missingMultiple(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3718 q3718 = new Q3718();
        int[] nums = {1, 4, 7, 10, 15};
        int k = 5;
        int expectResult = 5;
        int actualResult = q3718.missingMultiple(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
