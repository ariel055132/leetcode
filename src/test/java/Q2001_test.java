import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2001_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2001 q2001 = new Q2001();
        int[][] rectangles = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        long expectResult = 6;
        long actualResult = q2001.interchangeableRectangles(rectangles);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2001 q2001 = new Q2001();
        int[][] rectangles = {{4, 5}, {7, 8}};
        long expectResult = 0;
        long actualResult = q2001.interchangeableRectangles(rectangles);
        Assertions.assertEquals(expectResult,actualResult);
    }
}
