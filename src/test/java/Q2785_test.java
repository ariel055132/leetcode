import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2785_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q2785 q2785 = new Q2785();
        String s = "lEetcOde";
        String expectResult = "lEOtcede";
        String actualResult = q2785.sortVowels(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q2785 q2785 = new Q2785();
        String s = "lYmpH";
        String expectResult = "lYmpH";
        String actualResult = q2785.sortVowels(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
