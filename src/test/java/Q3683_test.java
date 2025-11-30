import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3683_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3683 q3683 = new Q3683();
        int[][] tasks = {{1, 6}, {2, 3}};
        int expectResult = 5;
        int actualResult = q3683.earliestTime(tasks);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3683 q3683 = new Q3683();
        int[][] tasks = {{100, 100}, {100, 100}, {100, 100}};
        int expectResult = 200;
        int actualResult = q3683.earliestTime(tasks);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
