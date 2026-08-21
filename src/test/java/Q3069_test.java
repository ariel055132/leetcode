import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3069_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3069 q3069 = new Q3069();
        int[] nums = {2, 1, 3};
        int[] expectResult = {2, 3, 1};
        int[] actualResult = q3069.resultArray(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3069 q3069 = new Q3069();
        int[] nums = {5, 4, 3, 8};
        int[] expectResult = {5, 3, 4, 8};
        int[] actualResult = q3069.resultArray(nums);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
