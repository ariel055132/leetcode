package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q658_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q658 q658 = new Q658();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> expectResult = List.of(1, 2, 3, 4);
        List<Integer> actualResult = q658.findClosestElement(arr, k, x);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q658 q658 = new Q658();
        int[] arr = {1, 1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> expectResult = List.of(1, 1, 2, 3);
        List<Integer> actualResult = q658.findClosestElement(arr, k, x);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
