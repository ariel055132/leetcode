import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1134_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1134 q1134 = new Q1134();
        int n = 153;
        boolean expectResult = true;
        // 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
        boolean actualResult = q1134.isArmstrong(n); 
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1134 q1134 = new Q1134();
        int n = 123;
        boolean expectResult = false;
        // 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36
        boolean actualResult = q1134.isArmstrong(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test Case")
    void test3() {
        Q1134 q1134 = new Q1134();
        int n = 2;
        boolean expectResult = true;
        boolean actualResult = q1134.isArmstrong(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
