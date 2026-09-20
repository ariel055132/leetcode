package BiWeeklyContest185;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2 q2 = new Q2();
        int[] lights = {0, 0, 0, 0};
        int expectResult = 2;
        int actualResult = q2.minAdditionalBulbs(lights);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q2 q2 = new Q2();
        int[] lights = {0, 0, 0, 2, 0};
        int expectResult = 1;
        int actualResult = q2.minAdditionalBulbs(lights);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
