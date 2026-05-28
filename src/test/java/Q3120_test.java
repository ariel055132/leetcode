import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3120_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3120 q3120 = new Q3120();
        String word = "aaAbcBC";
        int expectedResult = 3;
        int actualResult = q3120.numberOfSpecialChars(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3120 q3120 = new Q3120();
        String word = "abc";
        int expectedResult = 0;
        int actualResult = q3120.numberOfSpecialChars(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3120 q3120 = new Q3120();
        String word = "abBCab";
        int expectedResult = 1;
        int actualResult = q3120.numberOfSpecialChars(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
