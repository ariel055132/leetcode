import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2962_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q2962 q2962 = new Q2962();
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long expectResult = 6;
        long actualResult = q2962.countSubarrays(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q2962 q2962 = new Q2962();
        int[] nums = {1, 4, 2, 1};
        int k = 3;
        long expectResult = 0;
        long actualResult = q2962.countSubarrays(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
