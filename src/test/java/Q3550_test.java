import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3550_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q3550 q3550 = new Q3550();
        int[] nums = {1, 3, 2};
        int expectResult = 2;
        int actualResult = q3550.smallestIndex(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q3550 q3550 = new Q3550();
        int[] nums = {1, 10, 11};
        int expectResult = 1;
        int actualResult = q3550.smallestIndex(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 3")
    void test3() {
        Q3550 q3550 = new Q3550();
        int[] nums = {1, 2, 3};
        int expectResult = -1;
        int actualResult = q3550.smallestIndex(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
