import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q812_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q812 q812 = new Q812();
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        double expectResult = 2.0;
        double actualResult = q812.largestTriangleArea(points);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q812 q812 = new Q812();
        int[][] points = {{1, 0}, {0, 0}, {0, 1}};
        double expectResult = 0.5;
        double actualResult = q812.largestTriangleArea(points);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
