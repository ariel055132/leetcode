import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Blind75.Q1;

public class Q1680_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1680 q1680 = new Q1680();
        int n = 1;
        int expectResult = 1;
        int actualResult = q1680.concatenatedBinary(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1680 q1680 = new Q1680();
        int n = 3;
        int expectResult = 27;
        int actualResult = q1680.concatenatedBinary(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1680 q1680 = new Q1680();
        int n = 12;
        int expectResult = 505379714;
        int actualResult = q1680.concatenatedBinary(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void test4() {
        Q1680 q1680 = new Q1680();
        int n = 72387;
        
        int actualResult = q1680.concatenatedBinary(n);
        System.out.println(actualResult); // 851680433
    }
}
