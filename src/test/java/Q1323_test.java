import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1323_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q1323 q1323 = new Q1323();
        int num = 9669;
        int expectResult = 9969;
        int actualResult = q1323.maximum69Number(num);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
