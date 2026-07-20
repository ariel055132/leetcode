import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3658_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3658 q3658 = new Q3658();
        int n = 4;
        int expectResult = 4;
        int actualResult = q3658.gcdOfOddEvenSums(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3658 q3658 = new Q3658();
        int n = 5;
        int expectResult = 5;
        int actualResult = q3658.gcdOfOddEvenSums(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
