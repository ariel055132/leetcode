package WeeklyContest505;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2 q2 = new Q2();
        int n = 3;
        int k = 1;
        List<String> expectResult = Arrays.asList("000", "010", "100");
        List<String> actualResult = q2.generateValidStrings(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q2 q2 = new Q2();
        int n = 1;
        int k = 0;
        List<String> expectResult = Arrays.asList("0", "1");
        List<String> actualResult = q2.generateValidStrings(n, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
