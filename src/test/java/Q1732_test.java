import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1732_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1732 q1732 = new Q1732();
        int[] gain = {-5, 1, 5, 0, -7};
        // {0, -5, -4, 1, 0, -6}
        int expectResult = 1;
        int actualResult = q1732.largestAltitude(gain);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1732 q1732 = new Q1732();
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        // {0, -4, -7, -9, -10, -6, -3, -1}
        int expectResult = 0;
        int actualResult = q1732.largestAltitude(gain);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
