import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q219_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q219 q219 = new Q219();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean expectResult = true;
        boolean actualResult = q219.containsNearbyByDuplicate(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q219 q219 = new Q219();
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        boolean expectResult = true;
        boolean actualResult = q219.containsNearbyByDuplicate(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q219 q219 = new Q219();
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean expectResult = false;
        boolean actualResult = q219.containsNearbyByDuplicate(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
