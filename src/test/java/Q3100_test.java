import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3100_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3100 q3100 = new Q3100();
        int numBottles = 13;
        int numExchange = 6;
        int expectResult = 15;
        int actualResult = q3100.maxBottlesDrunk(numBottles, numExchange);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3100 q3100 = new Q3100();
        int numBottles = 10;
        int numExchange = 3;
        int expectResult = 13;
        int actualResult = q3100.maxBottlesDrunk(numBottles, numExchange);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
