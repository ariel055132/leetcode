package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1006_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1006 q1006 = new Q1006();
        int n = 4;
        int expectResult = 7;
        int actualResult = q1006.clumsy(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1006 q1006 = new Q1006();
        int n = 10;
        int expectResult = 12;
        int actualResult = q1006.clumsy(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
