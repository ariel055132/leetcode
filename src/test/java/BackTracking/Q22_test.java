package BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q22_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q22 q22 = new Q22();
        int n = 3;
        List<String> expectResult = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> actualResult = q22.generateParenthesis(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q22 q22 = new Q22();
        int n = 1;
        List<String> expectResult = List.of("()");
        List<String> actualResult = q22.generateParenthesis(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
