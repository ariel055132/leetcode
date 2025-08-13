import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q326_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q326 q326 = new Q326();
        boolean actualResult = q326.isPowerOfThree(27);
        boolean expectResult = true;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q326 q326 = new Q326();
        boolean actualResult = q326.isPowerOfThree(0);
        boolean expectResult = false;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q326 q326 = new Q326();
        boolean actualResult = q326.isPowerOfThree(-1);
        boolean expectResult = false;
        Assertions.assertEquals(expectResult, actualResult);
    }
}
