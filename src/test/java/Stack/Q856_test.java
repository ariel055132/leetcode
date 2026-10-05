package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q856_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q856 q856 = new Q856();
        String s = "()";
        int expectResult = 1;
        int actualResult = q856.scoreOfParentheses(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
