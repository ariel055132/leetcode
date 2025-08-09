package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q20_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q20 q20 = new Q20();
        String s = "()";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q20 q20 = new Q20();
        String s = "()[]{}";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q20 q20 = new Q20();
        String s = "(]";
        boolean expectResult = false;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 4")
    void example4() {
        Q20 q20 = new Q20();
        String s = "([])";
        boolean expectResult = true;
        boolean actualResult = q20.isValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
