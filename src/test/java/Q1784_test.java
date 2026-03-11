
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1784_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1784 q1784 = new Q1784();
        String s = "1001";
        boolean expectResult = false;
        boolean actualResult = q1784.checkOnesSegment(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1784 q1784 = new Q1784();
        String s = "110";
        boolean expectResult = true;
        boolean actualResult = q1784.checkOnesSegment(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
