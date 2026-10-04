package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q32_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q32 q32 = new Q32();
        String s = "(()";
        int expectResult = 2;
        int actualResult = q32.longValidParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q32 q32 = new Q32();
        String s = ")()())";
        int expectResult = 4;
        int actualResult = q32.longValidParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
