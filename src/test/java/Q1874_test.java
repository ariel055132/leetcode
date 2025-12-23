import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1874_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1874 q1874 = new Q1874();
        int[] nums1 = {5, 3, 4, 2};
        int[] nums2 = {4, 2, 2, 5};
        int expectResult = 40;
        int actualResult = q1874.minProductSum(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1874 q1874 = new Q1874();
        int[] nums1 = {2, 1, 4, 5, 7};
        int[] nums2 = {3, 2, 4, 8, 6};
        int expectResult = 65;
        int actualResult = q1874.minProductSum(nums1, nums2);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
