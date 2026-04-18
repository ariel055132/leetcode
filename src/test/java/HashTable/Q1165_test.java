package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1165_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q1165 q1165 = new Q1165();
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        int expectResult = 4;
        int actualResult = q1165.calculateTime(keyboard, word);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1165 q1165 = new Q1165();
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";
        int expectResult = 73;
        int actualResult = q1165.calculateTime(keyboard, word);
        Assertions.assertEquals(expectResult, actualResult);
    }

}
