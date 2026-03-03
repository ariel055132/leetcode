import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1545_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1545 q1545 = new Q1545();
        int n = 3;
        int k = 1;
        char expectResult = '0';
        char actualResult = q1545.findKthBit(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1545 q1545 = new Q1545();
        int n = 4;
        int k = 11;
        char expectResult = '1';
        char actualResult = q1545.findKthBit(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
    
}
