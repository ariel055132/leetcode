import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q231_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q231 q231 = new Q231();
        boolean actualResult = q231.isPowerOfTwo(1);
        boolean expectResult = true;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q231 q231 = new Q231();
        boolean actualResult = q231.isPowerOfTwo(16);
        boolean expectResult = true;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q231 q231 = new Q231();
        boolean actualResult = q231.isPowerOfTwo(3);
        boolean expectResult = false;
        Assertions.assertEquals(expectResult, actualResult);
    }
}
