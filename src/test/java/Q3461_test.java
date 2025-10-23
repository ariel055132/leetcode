import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3461_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3461 q3461 = new Q3461();
        String s = "3902";
        boolean expectResult = true;
        boolean actualResult = q3461.hasSameDigits(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3461 q3461 = new Q3461();
        String s = "34789";
        boolean expectResult = false;
        boolean actualResult = q3461.hasSameDigits(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
