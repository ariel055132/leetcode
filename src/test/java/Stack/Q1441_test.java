package Stack;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1441_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1441 q1441 = new Q1441();
        int[] target = {1, 3};
        int n = 3;
        List<String> expectResult = List.of("Push", "Push", "Pop", "Push");
        List<String> actualResult = q1441.buildArray(target, n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1441 q1441 = new Q1441();
        int[] target = {1, 2, 3};
        int n = 3;
        List<String> expectResult = List.of("Push", "Push", "Push");
        List<String> actualResult = q1441.buildArray(target, n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1441 q1441 = new Q1441();
        int[] target = {1, 2};
        int n = 4;
        List<String> expectResult = List.of("Push", "Push");
        List<String> actualResult = q1441.buildArray(target, n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
