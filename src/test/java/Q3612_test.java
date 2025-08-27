import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3612_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3612 q3612 = new Q3612();
        String s = "a#b%*";
        String expectResult = "ba";
        String actualResult = q3612.processStr(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test Case 2")
    void test2() {
        Q3612 q3612 = new Q3612();
        String s = "z*#";
        String expectResult = "";
        String actualResult = q3612.processStr(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test Case")
    void hiddenTestCase() {
        Q3612 q3612 = new Q3612();
        String s = "+%";
        String expectResult = "";
        String actualResult = q3612.processStr(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
