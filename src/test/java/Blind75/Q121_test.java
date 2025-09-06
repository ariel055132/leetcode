package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q121_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q121 q121 = new Q121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expectResult = 5;
        int actualResult = q121.maxProfit(prices);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q121 q121 = new Q121();
        int[] prices = {7, 6, 4, 3, 1};
        int expectResult = 0;
        int actualResult = q121.maxProfit(prices);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
