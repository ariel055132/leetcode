import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q840_test {
    @Test
    @DisplayName("Test magic square validation (duplicate numbers)")
    void testMagicSquareValidation() {
        Q840 q840 = new Q840();
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 6, 6, 11}};
        boolean expectResult = false;
        boolean actualResult = q840.isMagicSquare(grid, 0, 1);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test magic square validation (number exceed 10)")
    void testMagicSquareValidation1() {
        Q840 q840 = new Q840();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 11}};
        boolean expectResult = false;
        boolean actualResult = q840.isMagicSquare(grid, 0, 0);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test sum calculation")
    void testSumCalculation() {
        Q840 q840 = new Q840();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean expectResult = true;
        boolean actualResult = q840.isMagicSquare(grid, 0, 0);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
