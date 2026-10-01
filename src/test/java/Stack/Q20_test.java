package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q20_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q20 q20 = new Q20();
        String s = "()";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q20 q20 = new Q20();
        String s = "()[]{}";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q20 q20 = new Q20();
        String s = "(]";
        boolean expectResult = false;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q20 q20 = new Q20();
        String s = "([])";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        Q20 q20 = new Q20();
        String s = "([)]";
        boolean expectResult = false;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
