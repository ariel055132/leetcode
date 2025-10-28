package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q946_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q946 q946 = new Q946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean expectResult = true;
        boolean actualResult = q946.validateStackSequences(pushed, popped);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q946 q946 = new Q946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        boolean expectResult = false;
        boolean actualResult = q946.validateStackSequences(pushed, popped);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
