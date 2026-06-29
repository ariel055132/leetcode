import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1967_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1967 q1967 = new Q1967();
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        int expectResult = 3;
        int actualResult = q1967.numOfStrings(patterns, word);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1967 q1967 = new Q1967();
        String[] patterns = {"a", "b", "c"};
        String word = "aaaaabbbbb";
        int expectResult = 2;
        int actualResult = q1967.numOfStrings(patterns, word);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1967 q1967 = new Q1967();
        String[] patterns = {"a", "a", "a"};
        String word = "ab";
        int expectResult = 3;
        int actualResult = q1967.numOfStrings(patterns, word);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
