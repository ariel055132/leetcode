package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q921_test {

    @Test
    void midAddToMakeValid() {
        Q921 q921 = new Q921();
        String s = "())";
        int expectResult = 1;
        int actualResult = q921.midAddToMakeValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q921 q921 = new Q921();
        String s = "(((";
        int expectResult = 3;
        int actualResult = q921.midAddToMakeValid(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}