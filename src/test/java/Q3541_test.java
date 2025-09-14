import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3541_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q3541 q3541 = new Q3541();
        String s = "successes";
        int expectResult = 6;
        int actualResult = q3541.maxFreqSum(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q3541 q3541 = new Q3541();
        String s = "aeiaeia";
        int expectResult = 3;
        int actualResult = q3541.maxFreqSum(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
