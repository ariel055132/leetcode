import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1925_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1925 q1925 = new Q1925();
        int n = 5;
        int expectResult = 2;
        int actualResult = q1925.countTriples(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1925 q1925 = new Q1925();
        int n = 10;
        int expectResult = 4;
        int actualResult = q1925.countTriples(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
