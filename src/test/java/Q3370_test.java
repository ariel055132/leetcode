import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3370_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3370 q3370 = new Q3370();
        int n = 5;
        int expectResult = 7;
        int actualResult = q3370.smallestNumber(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
