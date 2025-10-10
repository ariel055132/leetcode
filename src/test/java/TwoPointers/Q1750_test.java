package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1750_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1750 q1750 = new Q1750();
        String s = "ca";
        int expectResult = 2;
        int actualResult = q1750.minimumLength(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1750 q1750 = new Q1750();
        String s = "cabaabac";
        int expectResult = 0;
        int actualResult = q1750.minimumLength(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1750 q1750 = new Q1750();
        String s = "aabccabba";
        int expectResult = 3;
        int actualResult = q1750.minimumLength(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
