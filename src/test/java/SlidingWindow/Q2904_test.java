package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2904_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2904 q2904 = new Q2904();
        String s = "100011001";
        int k = 3;
        String expectResult = "11001";
        String actualResult = q2904.shortestBeautifulSubstring(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2904 q2904 = new Q2904();
        String s = "1011";
        int k = 2;
        String expectResult = "11";
        String actualResult = q2904.shortestBeautifulSubstring(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2904 q2904 = new Q2904();
        String s = "000";
        int k = 1;
        String expectResult = "";
        String actualResult = q2904.shortestBeautifulSubstring(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test Case")
    void testHidden() {
        Q2904 q2904 = new Q2904();
        String s = "001110101101101111";
        int k = 10;
        String expectResult = "10101101101111";
        String actualResult = q2904.shortestBeautifulSubstring(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
