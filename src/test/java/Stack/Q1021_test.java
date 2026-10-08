package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q1021_test {

    @Test
    @DisplayName("Test 1")
    void removeOuterParentheses() {
        Q1021 q1021 = new Q1021();
        String s = "(()())(())";
        String expectResult = "()()()";
        String actualResult = q1021.removeOuterParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1021 q1021 = new Q1021();
        String s = "()()";
        String expectResult = "";
        String actualResult = q1021.removeOuterParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}