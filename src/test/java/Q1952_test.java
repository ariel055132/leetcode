import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1952_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1952 q1952 = new Q1952();
        int n = 2;
        boolean expectResult = false;
        boolean actualResult = q1952.isThree(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1952 q1952 = new Q1952();
        int n = 25;
        boolean expectResult = true;
        boolean actualResult = q1952.isThree(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
