package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q253_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q253 q253 = new Q253();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int expectResult = 2;
        int actualResult = q253.minMeetingRooms(intervals);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q253 q253 = new Q253();
        int[][] intervals = {{7, 10}, {2, 4}};
        int expectResult = 1;
        int actualResult = q253.minMeetingRooms(intervals);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
