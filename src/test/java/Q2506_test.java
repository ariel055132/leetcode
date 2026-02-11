import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2506_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2506 q2506 = new Q2506();
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        int expectResult = 2;
        int actualResult = q2506.similarPairs(words);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2506 q2506 = new Q2506();
        String[] words = {"aabb", "ab", "ba"};
        int expectResult = 3;
        int actualResult = q2506.similarPairs(words);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2506 q2506 = new Q2506();
        String[] words = {"nba", "cba", "dba"};
        int expectResult = 0;
        int actualResult = q2506.similarPairs(words);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
