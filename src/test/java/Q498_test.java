import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q498_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q498 q498 = new Q498();
        int[][] mat = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        int[] expectResult = {1, 2, 4, 7, 5, 3, 6, 8, 9};
        int[] actualResult = q498.findDiagonalOrder(mat);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
