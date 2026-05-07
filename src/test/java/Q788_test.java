import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q788_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q788 q788 = new Q788();
        int n = 10;
        int expectResult = 4;
        int actualResult = q788.rotatedDigits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q788 q788 = new Q788();
        int n = 1;
        int expectResult = 0;
        int actualResult = q788.rotatedDigits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q788 q788 = new Q788();
        int n = 2;
        int expectResult = 1;
        int actualResult = q788.rotatedDigits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void test4() {
        Q788 q788 = new Q788();
        int n = 857;
        int expectResult = 247;
        int actualResult = q788.rotatedDigits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
