package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1249_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1249 q1249 = new Q1249();
        String s = "lee(t(c)o)de)";
        String expectResult = "lee(t(c)o)de";
        String actualResult = q1249.minRemoveToMakeValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1249 q1249 = new Q1249();
        String s = "a)b(c)d";
        String expectResult = "ab(c)d";
        String actualResult = q1249.minRemoveToMakeValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1249 q1249 = new Q1249();
        String s = "))((";
        String expectResult = "";
        String actualResult = q1249.minRemoveToMakeValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
