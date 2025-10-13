import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q2273_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2273 q2273 = new Q2273();
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        List<String> expectResult = List.of("abba", "cd");
        List<String> actualResult = q2273.removeAnagrams(words);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1 - Alternative")
    void test1_Alternative() {
        Q2273 q2273 = new Q2273();
        String[] words = {"abba", "cd", "bbaa", "cd", "baba"};
        List<String> expectResult = List.of("abba", "cd");
        List<String> actualResult = q2273.removeAnagrams(words);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2273 q2273 = new Q2273();
        String[] words = {"a", "b", "c", "d", "e"};
        List<String> expectResult = List.of("a", "b", "c", "d", "e");
        List<String> actualResult = q2273.removeAnagrams(words);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
