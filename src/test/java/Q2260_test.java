import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2260_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2260 q2260 = new Q2260();
        int[] cards = {3, 4, 2, 3, 4, 7};
        int expectResult = 4;
        int actualResult = q2260.minimumCardPickUp(cards);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2260 q2260 = new Q2260();
        int[] cards = {1, 0, 5, 3};
        int expectResult = -1;
        int actualResult = q2260.minimumCardPickUp(cards);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2260 q2260 = new Q2260();
        int[] cards = {3, 2, 4, 4, 3, 7};
        int expectResult = 1;
        int actualResult = q2260.minimumCardPickUp(cards);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
