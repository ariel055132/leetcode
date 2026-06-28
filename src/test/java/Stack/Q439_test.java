package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q439_test {
    /**
     * Stack before ? -> 2:3
     * pop out num1: 2
     * pop out num2: 3
     * T -> push back num1 (2)
     * Finally, return 2
     * 
     * Note: if F -> push back num2 (3), return 3
     */
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q439 q439 = new Q439();
        String expression = "T?2:3";
        String expectResult = "2";
        String actualResult = q439.parseTernary(expression);
        Assertions.assertEquals(expectResult, actualResult);
    }

    /**
     * Stack before ?: 4:5
     * Pop out num1: 4
     * Pop out num2: 5
     * T -> push back num1 (4)
     * Now Expression: F?1:4, keep traversing
     * Stack before ? -> 1:4
     * Pop out num1: 1
     * Pop out num2: 4
     * F -> Push Back num2 (4)
     * return 4
     */
    @Test
    @DisplayName("Test 2")
    void test2() {
        Q439 q439 = new Q439();
        String expression = "F?1:T?4:5";
        String expectResult = "4";
        String actualResult = q439.parseTernary(expression);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test Case")
    void test3() {
        Q439 q439 = new Q439();
        String expression = "T?T?F:5:3";
        String expectResult = "F";
        String actualResult = q439.parseTernary(expression);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
