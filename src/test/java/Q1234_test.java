import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1234_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q1234 q1234 = new Q1234();
        String s = "QWER";
        int expectResult = 0;
        int actualResult = q1234.balancedString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q1234 q1234 = new Q1234();
        String s = "QQWE";
        int expectResult = 1;
        int actualResult = q1234.balancedString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
