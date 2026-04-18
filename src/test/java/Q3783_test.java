import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3783_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3783 q3783 = new Q3783();
        int n = 25;
        int expectResult = 27;
        int actualResult = q3783.mirrorDistance(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3783 q3783 = new Q3783();
        int n = 10;
        int expectResult = 9;
        int actualResult = q3783.mirrorDistance(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3783 q3783 = new Q3783();
        int n = 7;
        int expectResult = 0;
        int actualResult = q3783.mirrorDistance(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
