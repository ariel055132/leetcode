import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2264_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q2264 q2264 = new Q2264();
        String actualResult = q2264.largestGoodInteger("6777133339");
        String expectResult = "777";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q2264 q2264 = new Q2264();
        String actualResult = q2264.largestGoodInteger("2300019");
        String expectResult = "000";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q2264 q2264 = new Q2264();
        String actualResult = q2264.largestGoodInteger("123");
        String expectResult = "";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 4")
    void example4() {
        Q2264 q2264 = new Q2264();
        String actualResult = q2264.largestGoodInteger("222");
        String expectResult = "222";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 5")
    void example5() {
        Q2264 q2264 = new Q2264();
        String actualResult = q2264.largestGoodInteger("1221000");
        String expectResult = "000";
        Assertions.assertEquals(expectResult, actualResult);
    }
}
