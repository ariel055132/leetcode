import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1004_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1004 q1004 = new Q1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int expectResult = 6;
        int actualResult = q1004.longestOnes(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
