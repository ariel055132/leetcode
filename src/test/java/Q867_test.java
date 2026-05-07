import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q867_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q867 q867 = new Q867();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectResult = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] actualResult = q867.transpose(matrix);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q867 q867 = new Q867();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] expectResult = {{1, 4}, {2, 5}, {3, 6}};
        int[][] actualResult = q867.transpose(matrix);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
