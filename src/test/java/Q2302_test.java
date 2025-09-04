import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2302_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q2302 q2302 = new Q2302();
        int[] nums = {2, 1, 4, 3, 5};
        long k = 10;
        long expectResult = 6;
        long actualResult = q2302.countSubarrays(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
