import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3622_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3622 q3622 = new Q3622();
        int n = 99;
        boolean expectResult = true;
        boolean actualResult = q3622.checkDivisiblilty(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3622 q3622 = new Q3622();
        int n = 23;
        boolean expectResult = false;
        boolean actualResult = q3622.checkDivisiblilty(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
