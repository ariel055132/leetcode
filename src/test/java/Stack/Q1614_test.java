package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1614_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1614 q1614 = new Q1614();
        String s = "(1+(2*3)+((8)/4))+1";
        int expectResult = 3;
        int actualResult = q1614.maxDepth(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1614 q1614 = new Q1614();
        String s = "(1)+((2))+(((3)))";
        int expectResult = 3;
        int actualResult = q1614.maxDepth(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1614 q1614 = new Q1614();
        String s = "()(())((()()))";
        int expectResult = 3;
        int actualResult = q1614.maxDepth(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
