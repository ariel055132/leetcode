import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Q2438_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        int n = 15;
        int[][] queries = {{0, 1}, {2, 2}, {0, 3}};
        int[] expectResult = {2, 4, 64};
        int[] actualResult = new Q2438().productQueries(n, queries);
        assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        int n = 2;
        int[][] queries = {{0, 0}};
        int[] expectResult = {2};
        int[] actualResult = new Q2438().productQueries(n, queries);
        assertArrayEquals(expectResult, actualResult);
    }
}
