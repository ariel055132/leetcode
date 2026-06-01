import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2144_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2144 q2144 = new Q2144();
        int[] cost = {1, 2, 3};
        int expectResult = 5;
        int actualResult = q2144.minimumCost(cost);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2144 q2144 = new Q2144();
        int[] cost = {6, 5, 7, 9, 2, 2};
        int expectResult = 23;
        int actualResult = q2144.minimumCost(cost);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("test 3")
    void test3() {
        Q2144 q2144 = new Q2144();
        int[] cost = {5, 5};
        int expectResult = 10;
        int actualResult = q2144.minimumCost(cost);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
