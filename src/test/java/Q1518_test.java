import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1518_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1518 q1518 = new Q1518();
        int numBottles = 9;
        int numExchange = 3;
        int expectResult = 13;
        int actualResult = q1518.numWaterBottles(numBottles, numExchange);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1518 q1518 = new Q1518();
        int numBottles = 15;
        int numExchange = 4;
        int expectResult = 19;
        int actualResult = q1518.numWaterBottles(numBottles, numExchange);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
