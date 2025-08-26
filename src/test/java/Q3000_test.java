import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3000_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q3000 q3000 = new Q3000();
        int[][] dimensions = {{9, 3}, {8, 6}};
        int expectResult = 48;
        int actualResult = q3000.areaOfMaxDiagonal(dimensions);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q3000 q3000 = new Q3000();
        int[][] dimensions = {{3, 4},{4, 3}};
        int expectResult = 12;
        int actualResult = q3000.areaOfMaxDiagonal(dimensions);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
