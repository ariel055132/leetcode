package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q125_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q125 q125 = new Q125();
        String s = "A man, a plan, a canal: Panama";
        boolean expectResult = true;
        boolean actualResult = q125.isPalindrome(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q125 q125 = new Q125();
        String s = "race a car";
        boolean expectResult = false;
        boolean actualResult = q125.isPalindrome(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q125 q125 = new Q125();
        String s = " ";
        boolean expectResult = true;
        boolean actualResult = q125.isPalindrome(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
