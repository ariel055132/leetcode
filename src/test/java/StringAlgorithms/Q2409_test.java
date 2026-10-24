package StringAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2409_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2409 q2409 = new Q2409();
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        int expectResult = 3;
        int actualResult = q2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2409 q2409 = new Q2409();
        String arriveAlice = "10-01";
        String leaveAlice = "10-31";
        String arriveBob = "11-01";
        String leaveBob = "12-31";
        int expectResult = 0;
        int actualResult = q2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void test3() {
        Q2409 q2409 = new Q2409();
        String arriveAlice = "10-20";
        String leaveAlice = "12-22";
        String arriveBob = "06-21";
        String leaveBob = "07-05";
        int expectResult = 0;
        int actualResult = q2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
