import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3754_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3754 q3754 = new Q3754();
        int n = 10203004;
        /**
         * x = 1234
         * sum = 1+2+3+4 = 10
         * result = 1234 * 10 = 12340
         */
        long expectResult = 12340;
        long actualResult = q3754.sumAndMultiply(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3754 q3754 = new Q3754();
        int n = 1000;
        long expectResult = 1;
        long actualResult = q3754.sumAndMultiply(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void test3() {
        Q3754 q3754 = new Q3754();
        int n = 0;
        long expectResult = 0;
        long actualResult = q3754.sumAndMultiply(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
