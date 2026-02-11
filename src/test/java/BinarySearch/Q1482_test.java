package BinarySearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1482_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1482 q1482 = new Q1482();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int expectResult = 3;
        int actualResult = q1482.minDays(bloomDay, m, k);
    }
}
