import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3151_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3151 q3151 = new Q3151();
        int[] nums = {1};
        boolean expectResult = true;
        boolean actualResult = q3151.isArraySpecial(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3151 q3151 = new Q3151();
        int[] nums = {2, 1, 4};
        boolean expectResult = true;
        boolean actualResult = q3151.isArraySpecial(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3151 q3151 = new Q3151();
        int[] nums = {4, 3, 1, 6};
        boolean expectResult = false;
        boolean actualResult = q3151.isArraySpecial(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
