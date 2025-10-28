package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q844_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q844 q844 = new Q844();
        String s = "ab#c";
        String t = "ad#c";
        boolean expectResult = true;
        boolean actualResult = q844.backSpaceCompare(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q844 q844 = new Q844();
        String s = "ab##";
        String t = "c#d#";
        boolean expectResult = true;
        boolean actualResult = q844.backSpaceCompare(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q844 q844 = new Q844();
        String s = "a#c";
        String t = "b";
        boolean expectResult = false;
        boolean actualResult = q844.backSpaceCompare(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
