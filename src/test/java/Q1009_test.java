import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1009_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1009 q1009 = new Q1009();
        int n = 5;
        int expectResult = 2;
        int actualResult = q1009.bitwiseComplement(n);
        Assertions.assertEquals(expectResult, actualResult);
    }    
}
