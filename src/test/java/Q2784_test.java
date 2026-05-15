import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2784_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2784 q2784 = new Q2784();
        int[] nums = {2, 1, 3};
        boolean expectResult = false;
        boolean actualResult = q2784.isGood(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2784 q2784 = new Q2784();
        int[] nums = {1, 3, 3, 2};
        boolean expectResult = true;
        boolean actualResult = q2784.isGood(nums);
        Assertions.assertEquals(expectResult, actualResult); 
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2784 q2784 = new Q2784();
        int[] nums = {1, 1};
        boolean expectResult = true;
        boolean actualResult = q2784.isGood(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q2784 q2784 = new Q2784();
        int[] nums = {3, 4, 4, 1, 2, 1};
        boolean expectResult = false;
        boolean actualResult = q2784.isGood(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
