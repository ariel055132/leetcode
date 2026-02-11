import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1984_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1984 q1984 = new Q1984();
        int[] nums = {90};
        int k = 1;
        int expectResult = 0;
        int actualResult = q1984.minimumDifference(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1984 q1984 = new Q1984();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int expectResult = 2;
        int actualResult = q1984.minimumDifference(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
