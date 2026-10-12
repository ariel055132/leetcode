package Blind75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q252_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q252 q252 = new Q252();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        boolean expectResult = false;
        boolean actualResult = q252.canAttendMeetings(intervals);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q252 q252 = new Q252();
        int[][] intervals = {{7, 10}, {2, 4}};
        boolean expectResult = true;
        boolean actualRseult = q252.canAttendMeetings(intervals);
        Assertions.assertEquals(expectResult, actualRseult);
    }
}
