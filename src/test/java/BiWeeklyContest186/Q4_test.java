package BiWeeklyContest186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q4_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q4 q4 = new Q4();
        String word1 = "abc";
        String word2 = "bac";
        String target = "abc";
        int expectResult = 5;
        int actualResult = q4.interleaveCharacters(word1, word2, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q4 q4 = new Q4();
        String word1 = "cd";
        String word2 = "cd";
        String target = "ccd";
        int expectResult = 4;
        int actualResult = q4.interleaveCharacters(word1, word2, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q4 q4 = new Q4();
        String word1 = "xy";
        String word2 = "xy";
        String target = "xyxy";
        int expectResult = 2;
        int actualResult = q4.interleaveCharacters(word1, word2, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q4 q4 = new Q4();
        String word1 = "ab";
        String word2 = "cde";
        String target = "ade";
        int expectResult = 1;
        int actualResult = q4.interleaveCharacters(word1, word2, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
