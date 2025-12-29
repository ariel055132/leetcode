package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q8_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q8 q8 = new Q8();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int expectResult = 9;
        int actualResult = q8.evalRPN(tokens);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q8 q8 = new Q8();
        String[] tokens = {"4", "13", "5", "/", "+"};
        int expectResult = 6;
        int actualResult = q8.evalRPN(tokens);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q8 q8 = new Q8();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expectResult = 22;
        int actualResult = q8.evalRPN(tokens);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
