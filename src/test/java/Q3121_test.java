import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3121_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3121 q3121 = new Q3121();
        String word = "aaAbcBC";
        int expectResult = 3;
        int actualResult = q3121.numberOfSpecialChars(word);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3121 q3121 = new Q3121();
        String word = "abc";
        int expectResult = 0;
        int actualResult = q3121.numberOfSpecialChars(word);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3121 q3121 = new Q3121();
        String word = "AbBCab";
        int expectResult = 0;
        int actualResult = q3121.numberOfSpecialChars(word);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
