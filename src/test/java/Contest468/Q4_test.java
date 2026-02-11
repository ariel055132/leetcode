package Contest468;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q4_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q4 q4 = new Q4();
        int[] nums = {1, 3, 2};
        int k = 2;
        long expectResult = 4;
        long actualResult = q4.maxTotalValue(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
