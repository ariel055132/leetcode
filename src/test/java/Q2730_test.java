import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2730_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q2730 q2730 = new Q2730();
        String s = "52233";
        int actualResult = q2730.longestSemiRepetitiveSubstring(s);
        int expectResult = 4;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q2730 q2730 = new Q2730();
        String s = "5494";
        int actualResult = q2730.longestSemiRepetitiveSubstring(s);
        int expectResult = 4;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q2730 q2730 = new Q2730();
        String s = "1111111";
        int expectResult = 2;
        int actualResult = q2730.longestSemiRepetitiveSubstring(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
