import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1461_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1461 q1461 = new Q1461();
        String s = "00110110";
        int k = 2;
        boolean expectResult = true;
        boolean actualResult = q1461.hasAllCodes(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }    

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1461 q1461 = new Q1461();
        String s = "0110";
        int k = 1;
        boolean expectResult = true;
        boolean actualResult = q1461.hasAllCodes(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1461 q1461 = new Q1461();
        String s = "0110";
        int k = 2;
        boolean expectResult = false;
        boolean actualResult = q1461.hasAllCodes(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Case")
    void hiddenCase() {
        Q1461 q1461 = new Q1461();
        String s = "00110";
        int k = 2;
        boolean expectResult = true;
        boolean actualResult = q1461.hasAllCodes(s, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
