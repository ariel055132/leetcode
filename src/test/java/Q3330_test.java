import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3330_test {
    @Test
    @DisplayName("Example 1")
    void testExample1() {
        Q3330 q3330 = new Q3330();
        String word = "abbcccc";
        int expectedResult = 5;
        int actualResult = q3330.possibleStringCount(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void testExample2() {
        Q3330 q3330 = new Q3330();
        String word = "abcd";
        int expectedResult = 1;
        int actualResult = q3330.possibleStringCount(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
