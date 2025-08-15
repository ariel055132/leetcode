import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q342_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q342 q342 = new Q342();
        int n = 16;
        boolean expectResult = true;
        boolean actualResult = q342.isPowerOfFour(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q342 q342 = new Q342();
        int n = 5;
        boolean expectResult = false;
        boolean actualResult = q342.isPowerOfFour(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q342 q342 = new Q342();
        int n = 1;
        boolean expectResult = true;
        boolean actualResult = q342.isPowerOfFour(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
