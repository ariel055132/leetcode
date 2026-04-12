package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q266_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q266 q266 = new Q266();
        String s = "code";
        boolean expectResult = false;
        boolean actualResult = q266.canPermutePalindrome(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("")
    void test2() {
        Q266 q266 = new Q266();
        String s = "aab";
        boolean expectResult = true;
        boolean actualResult = q266.canPermutePalindrome(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("")
    void test3() {
        
    }
}
