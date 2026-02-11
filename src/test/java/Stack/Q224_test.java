package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q224_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q224 q224 = new Q224();
        String s = "1 + 1";
        int expectResult = 2;
        int actualResult = q224.calculate(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q224 q224 = new Q224();
        String s = "2 - 1 + 2";
        int expectResult = 3;
        int actualResult = q224.calculate(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
