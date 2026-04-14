import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q280_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q280 q280 = new Q280();
        int[] nums = {3,5,2,1,6,4};
        q280.wiggleSort(nums);
        int[] expectResult = {1, 3, 2, 5, 4, 6};
        Assertions.assertArrayEquals(expectResult, nums);
    }
}
