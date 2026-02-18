import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q693_test {
    @Test
    @DisplayName("Test Case 1")
    void test1() {
        Q693 q693 = new Q693();
        int n = 5;
        boolean expectResult = true;
        boolean actualResult = q693.hasAlternatingBits(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
