package BiWeeklyContest185;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1 q1 = new Q1();
        int m = 2;
        int n = 3;
        String[] expectResult = {"..#", "#.."};
        String[] actualResult = q1.uniquePathGrid(m, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1 q1 = new Q1();
        int m = 3;
        int n = 3;
        String[] expectResult = {"..#","#..","##."};
        String[] actualResult = q1.uniquePathGrid(m, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1 q1 = new Q1();
        int m = 1;
        int n = 4;
        String[] expectResult = {"...."};
        String[] actualResult = q1.uniquePathGrid(m, n);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}