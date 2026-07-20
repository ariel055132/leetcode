import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3737_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3737 q3737 = new Q3737();
        int[] nums = {1, 2, 2, 3};
        int target = 2;
        int expectResult = 5;
        int actualResult = q3737.countMajoritySubarrays(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3737 q3737 = new Q3737();
        int[] nums = {1, 1, 1, 1};
        int target = 1;
        int expectResult = 10;
        int actualResult = q3737.countMajoritySubarrays(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3737 q3737 = new Q3737();
        int[] nums = {1, 2, 3};
        int target = 4;
        int expectResult = 0;
        int actualResult = q3737.countMajoritySubarrays(nums, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
