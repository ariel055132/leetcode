import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1317_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q1317 q1317 = new Q1317();
        int n = 2;
        int[] expectResult = {1, 1};
        int[] actualResult = q1317.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q1317 q1317 = new Q1317();
        int n = 11;
        int[] expectResult = {2, 9};
        int[] actualResult = q1317.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
