import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1935_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1935 q1935 = new Q1935();
        String text = "hello world";
        String brokenLetters = "ad";
        int expectResult = 1;
        int actualResult = q1935.canBeTypedWords(text, brokenLetters);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1935 q1935 = new Q1935();
        String text = "leet code";
        String brokenLetters = "lt";
        int expectResult = 1;
        int actualResult = q1935.canBeTypedWords(text, brokenLetters);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1935 q1935 = new Q1935();
        String text = "leet code";
        String brokenLetters = "e";
        int expectResult = 0;
        int actualResult = q1935.canBeTypedWords(text, brokenLetters);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
