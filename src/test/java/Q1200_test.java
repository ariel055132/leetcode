import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1200 q1200 = new Q1200();
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> expectResult = new ArrayList<>();
        List<Integer> result1 = Arrays.asList(1, 2);
        List<Integer> result2 = Arrays.asList(2, 3);
        List<Integer> result3 = Arrays.asList(3, 4);
        expectResult.add(result1);
        expectResult.add(result2);
        expectResult.add(result3);
        List<List<Integer>> actualResult = q1200.minimumAbsDifference(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1200 q1200 = new Q1200();
        int[] arr = {1, 3, 6, 10, 15};
        List<List<Integer>> expectResult = new ArrayList<>();
        List<Integer> result1 = Arrays.asList(1, 3);
        expectResult.add(result1);
        List<List<Integer>> actualResult = q1200.minimumAbsDifference(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1200 q1200 = new Q1200();
        int[] arr = {3, 9, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> expectResult = new ArrayList<>();
        List<Integer> result1 = Arrays.asList(-14, -10);
        List<Integer> result2 = Arrays.asList(19, 23);
        List<Integer> result3 = Arrays.asList(23, 27);
        expectResult.add(result1);
        expectResult.add(result2);
        expectResult.add(result3);
        List<List<Integer>> actualResult = q1200.minimumAbsDifference(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
