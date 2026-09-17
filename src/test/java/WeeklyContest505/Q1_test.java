package WeeklyContest505;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q1 q1 = new Q1();
        int expectResult = 10;
        int n = 2;
        int k = 3;
        int actualResult = q1.sumOfGoodIntegers(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q1 q1 = new Q1();
        int expectResult = 0;
        int n = 5;
        int k = 1;
        int actualResult = q1.sumOfGoodIntegers(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
