import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1582_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1582 q1582 = new Q1582();
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        /**
         * 1 0 0 
         * 0 0 [1]
         * 1 0 0
         * 
         * Return 1
         */
        int expectResult = 1;
        int actualResult = q1582.numSpecial(mat);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1582 q1582 = new Q1582();
        int[][] mat = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        /**
         * 1 0 0 
         * 0 1 0
         * 0 0 1
         */
        int expectResult = 3;
        int actualResult = q1582.numSpecial(mat);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test Case")
    void hiddenTest() {
        Q1582 q1582 = new Q1582();
        int[][] mat = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}};
        /**
         * 0 0 1 0 
         * 0 0 0 0 
         * 0 0 0 0 
         * 0 1 0 0
         */
        int expectResult = 2;
        int actualResult = q1582.numSpecial(mat);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
