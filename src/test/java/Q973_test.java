import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q973_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q973 q973 = new Q973();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] expectResult = {{-2, 2}};
        int[][] actualResult = q973.kClosest(points, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q973 q973 = new Q973();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] expectResult = {{3, 3}, {-2, 4}};
        int[][] actualResult = q973.kClosest(points, k);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
