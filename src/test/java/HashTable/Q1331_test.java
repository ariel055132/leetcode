package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1331_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1331 q1331 = new Q1331();
        int[] arr = {40, 10, 20, 30};
        int[] expectResult = {4, 1, 2, 3};
        int[] actualResult = q1331.arrayRankTransform(arr);
        Assertions.assertArrayEquals(expectResult, actualResult);
    } 

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1331 q1331 = new Q1331();
        int[] arr = {100, 100, 100};
        int[] expectResult = {1, 1, 1};
        int[] actualResult = q1331.arrayRankTransform(arr);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1331 q1331 = new Q1331();
        int[] arr = {37, 12, 28, 9 , 100, 56, 80, 5, 12};
        int[] expectResult = {5, 3, 4, 2, 8, 6, 7, 1, 3};
        int[] actualResult = q1331.arrayRankTransform(arr);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
