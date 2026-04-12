package WeeklyContest493;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3870_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3870 q3870 = new Q3870();
        int n = 1002;
        int expectResult = 3;
        int actualResult = q3870.countCommas(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3870 q3870 = new Q3870();
        int n = 998;
        int expectResult = 0;
        int actualResult = q3870.countCommas(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
