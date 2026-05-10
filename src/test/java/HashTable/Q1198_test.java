package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1198_test {
    @Test
    @DisplayName("Test 1")
    void test1() { 
        Q1198 q1198 = new Q1198();
        int[][] mat = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        int expectResult = 5;
        int actualResult = q1198.smallestCommonElement(mat);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void hiddenTest() {
        Q1198 q1198 = new Q1198();
        int[][] mat = {{1, 2, 3}, {2, 3, 4}, {2, 3, 5}};
        int expectResult = 2;
        int actualResult = q1198.smallestCommonElement(mat);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
