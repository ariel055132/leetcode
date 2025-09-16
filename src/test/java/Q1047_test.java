import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1047_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1047 q1047 = new Q1047();
        String s = "abbaca";
        String expectResult = "ca";
        String actualResult = q1047.removeDuplicates(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1047 q1047 = new Q1047();
        String s = "azxxzy";
        String expectResult = "ay";
        String actualResult = q1047.removeDuplicates(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
