import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1523_WA_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1523_WA q1523WA = new Q1523_WA();
        int low = 3;
        int high = 7;
        int expectResult = 3;
        int actualResult = q1523WA.countOdds(low, high);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
