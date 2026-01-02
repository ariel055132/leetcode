import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1010_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1010 q1010 = new Q1010();
        int[] time = {30, 20, 150, 100, 40};
        int expectResult = 3;
        int actualResult = q1010.numPairsDivisibleBy60(time);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1010 q1010 = new Q1010();
        int[] time = {60, 60, 60};
        int expectResult = 3;
        int actualResult = q1010.numPairsDivisibleBy60(time);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1010 q1010 = new Q1010();
        int[] time = {15, 63, 451, 213, 37, 209, 343, 319};
        int expectResult = 1;
        int actualResult = q1010.numPairsDivisibleBy60(time);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
