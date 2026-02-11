package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q394_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q394 q394 = new Q394();
        String s = "3[a]2[bc]";
        String expectResult = "aaabcbc";
        String actualResult = q394.decodeString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
