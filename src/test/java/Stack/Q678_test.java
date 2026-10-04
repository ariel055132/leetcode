package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q678_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q678 q678 = new Q678();
        String s = "()";
        boolean expectResult = true;
        boolean actualRseult = q678.checkValidString(s);
        Assertions.assertEquals(expectResult, actualRseult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q678 q678 = new Q678();
        String s = "(*)";
        boolean expectResult = true;
        boolean actualResult = q678.checkValidString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
