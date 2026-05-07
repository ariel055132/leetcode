import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2078_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2078 q2078 = new Q2078();
        int[] colors = {1, 1, 1, 6, 1, 1, 1};
        int expectResult = 3;
        int actualResult = q2078.maxDistance(colors);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2078 q2078 = new Q2078();
        int[] colors = {1, 8, 3, 8, 3};
        int expectResult = 4;
        int actualResult = q2078.maxDistance(colors);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
