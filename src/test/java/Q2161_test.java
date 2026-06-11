import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2161_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2161 q2161 = new Q2161();
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int[] expectResult = {9, 5, 3, 10, 10, 12, 14};
        int[] actualResult = q2161.pivotArray(nums, 10);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
    
    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2161 q2161 = new Q2161();
        int[] nums = {-3, 4, 3, 2};
        int pivot = 2;
        int[] expectResult = {-3, 2, 4, 3};
        int[] actualResult = q2161.pivotArray(nums, pivot);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
