package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q291_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q291 q291 = new Q291();
        String pattern = "abab";
        String s = "redblueredblue";
        boolean expectResult = true;
        boolean actualResult = q291.wordPatternMatch(pattern, s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q291 q291 = new Q291();
        String pattern = "aaaa";
        String s = "asdasdasdasd";
        boolean expectResult = true;
        boolean actualResult = q291.wordPatternMatch(pattern, s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 3")
    void test3() {
        Q291 q291 = new Q291();
        String pattern = "aabb";
        String s = "xyzabcxzyabc";
        boolean expectResult = false;
        boolean actualResult = q291.wordPatternMatch(pattern, s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
