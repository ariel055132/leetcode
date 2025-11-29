import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1894_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1894 q1894 = new Q1894();
        int[] chalk = {5, 1, 5};
        int k = 22;
        int expectResult = 0;
        int actualResult = q1894.chalkReplacer(chalk, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1894 q1894 = new Q1894();
        int[] chalk = {3, 4, 1, 2};
        int k = 25;
        int expectResult = 1;
        int actualResult = q1894.chalkReplacer(chalk, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
