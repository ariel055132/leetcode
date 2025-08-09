package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q11_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q11 q11 = new Q11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expectResult = 49;
        int actualResult = q11.maxArea(height);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q11 q11 = new Q11();
        int[] height = {1, 1};
        int expectResult = 1;
        int actualResult = q11.maxArea(height);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
