import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1344_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1344 q1344 = new Q1344();
        int hour = 12;
        int minutes = 30;
        double expectResult = 165;
        double actualResult = q1344.angleClock(hour, minutes);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1344 q1344 = new Q1344();
        int hour = 3;
        int minute = 30;
        double expectResult = 75;
        double actualResult = q1344.angleClock(hour, minute);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1344 q1344 = new Q1344();
        int hour = 3;
        int minute = 15;
        double expectResult = 7.5;
        double actualResult = q1344.angleClock(hour, minute);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void test4() {
        Q1344 q1344 = new Q1344();
        int hour = 1;
        int minute = 57;
        double expectResult = 76.5;
        double actualResult = q1344.angleClock(hour, minute);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
