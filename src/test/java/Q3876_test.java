import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3876_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3876 q3876 = new Q3876();
        int[] nums1 = {1, 4, 7};
        boolean actualResult = q3876.uniformArray(nums1);
        boolean expectResult = true;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3876 q3876 = new Q3876();
        int[] nums1 = {2, 3};
        boolean actualResult = q3876.uniformArray(nums1);
        boolean expectResult = false;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3876 q3876 = new Q3876();
        int[] nums1 = {4, 6};
        boolean expectResult = true;
        boolean actualResult = q3876.uniformArray(nums1);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
