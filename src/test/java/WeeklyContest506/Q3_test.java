package WeeklyContest506;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3 q3 = new Q3();
        int[][] units = {{1, 3}, {2, 2}};
        long ratings = 4;
        long actualResult = q3.maxRatingSum(units);
        Assertions.assertEquals(ratings, actualResult );
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3 q3 = new Q3();
        int[][] units = {{1, 2, 3}, {4, 5, 6}};
        long ratings = 6;
        long actualResult = q3.maxRatingSum(units);
        Assertions.assertEquals(ratings, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3 q3 = new Q3();
        int[][] units = {{5, 5, 5}, {1, 1, 1}};
        long ratings = 6;
        long actualResult = q3.maxRatingSum(units);
        Assertions.assertEquals(ratings, actualResult);
    }
}
