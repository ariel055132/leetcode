package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q682_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q682 q682 = new Q682();
        String[] operation = {"5","2","C","D","+"};
        int expectResult = 30;
        int actualResult = q682.calPoints(operation);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q682 q682 = new Q682();
        String[] operations = {"5","-2","4","C","D","9","+","+"};
        int expectResult = 27;
        int actualResult = q682.calPoints(operations);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q682 q682 = new Q682();
        String[] operations = {"1", "C"};
        int expectResult = 0;
        int actualResult = q682.calPoints(operations);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
