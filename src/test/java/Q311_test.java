import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q311_test {
    @Test
    @DisplayName("Test 1") 
    void test1() {
        Q311 q311 = new Q311();
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] expectResult = {{7, 0, 0}, {-7, 0, 3}};
        int[][] actualResult = q311.multiply(mat1, mat2);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q311 q311 = new Q311();
        int[][] mat1 = {{0}};
        int[][] mat2 = {{0}};
        int[][] expectResult = {{0}};
        int[][] actualResult = q311.multiply(mat1, mat2);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
