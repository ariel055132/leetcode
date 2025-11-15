import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3557_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3557 q3557 = new Q3557();
        String word = "abcdeafdef";
        int expectResult = 2;
        int actualResult = q3557.maxSubstring(word);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
