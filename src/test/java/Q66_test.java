import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q66_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q66 q66 = new Q66();
        int[] digits = {1, 2, 3};
        int[] expectResult = {1, 2, 4};
        int[] actualResult = q66.plusOne(digits);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q66 q66 = new Q66();
        int[] digits = {9};
        int[] expectResult = {1, 0};
        int[] actualResult = q66.plusOne(digits);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
