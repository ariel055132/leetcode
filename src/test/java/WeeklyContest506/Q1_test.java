package WeeklyContest506;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q1 q1 = new Q1();
        int n = 1000;
        boolean expectResult = false;
        boolean actualResult = q1.checkGoodInteger(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q1 q1 = new Q1();
        int n = 19;
        boolean expectResult = true;
        boolean actualResult = q1.checkGoodInteger(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
