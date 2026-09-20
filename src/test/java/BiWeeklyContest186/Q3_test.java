package BiWeeklyContest186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3 q3 = new Q3();
        String s1 = "11";
        String s2 = "00";
        int expectResult = 1;
        int actualResult = q3.minOperations(s1, s2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3 q3 = new Q3();
        String s1 = "01";
        String s2 = "10";
        int expectResult = 3;
        int actualResult = q3.minOperations(s1, s2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3 q3 = new Q3();
        String s1 = "1";
        String s2 = "0";
        int expectResult = -1;
        int actualResult = q3.minOperations(s1, s2);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
