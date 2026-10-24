package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3185_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3185 q3185 = new Q3185();
        int[] hours = {12, 12, 30, 24, 24};
        long expectResult = 2;
        long actualResult = q3185.countCompleteDayPairs(hours);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3185 q3185 = new Q3185();
        int[] hours = {72, 48, 24, 3};
        long expectResult = 3;
        long actualResult = q3185.countCompleteDayPairs(hours);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
