import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q693_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q693 q693 = new Q693();
        int n = 5; // 101
        boolean expectResult = true;
        boolean actualResult = q693.hasAlternatingBits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q693 q693 = new Q693();
        int n = 7; // 111
        boolean expectResult = false;
        boolean actualResult = q693.hasAlternatingBits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q693 q693 = new Q693();
        int n = 11;
        boolean expectResult = false;
        boolean actualResult = q693.hasAlternatingBits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
