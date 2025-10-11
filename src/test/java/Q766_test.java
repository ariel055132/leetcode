import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q766_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q766 q766 = new Q766();
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        boolean expectResult = true;
        boolean actualResult = q766.isToeplitzMatrix(matrix);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q766 q766 = new Q766();
        int[][] matrix = {{1, 2}, {2, 2}};
        boolean expectResult = false;
        boolean actualResult = q766.isToeplitzMatrix(matrix);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
