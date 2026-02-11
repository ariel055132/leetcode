package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1190_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1190 q1190 = new Q1190();
        String s = "(abcd)";
        String expectResult = "dcba";
        String actualResult = q1190.reverseParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1190 q1190 = new Q1190();
        String s = "(u(love)i)";
        String expectResult = "iloveu";
        String actualResult = q1190.reverseParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
