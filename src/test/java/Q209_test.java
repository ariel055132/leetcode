import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q209_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q209 q209 = new Q209();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int actualResult = q209.minSubArrayLen(target, nums);

    }
}
