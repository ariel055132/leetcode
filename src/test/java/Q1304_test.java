import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1304_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q1304 q1304 = new Q1304();
        int n = 5;
        int[] expectResult = {1, -1, 2, -2, 0};
        int[] actualResult = q1304.subZero(n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q1304 q1304 = new Q1304();
        int n = 3;
        int[] expectResult = {1, -1, 0};
        int[] actualResult = q1304.subZero(n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q1304 q1304 = new Q1304();
        int n = 1;
        int[] expectResult = {0};
        int[] actualResult = q1304.subZero(n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
