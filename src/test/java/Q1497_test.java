import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1497_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1497 q1497 = new Q1497();
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        boolean expectResult = true;
        boolean actualResult = q1497.canArrange(arr, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1497 q1497 = new Q1497();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;
        boolean expectResult = true;
        boolean actualResult = q1497.canArrange(arr, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1497 q1497 = new Q1497();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 10;
        boolean expectResult = false;
        boolean actualResult = q1497.canArrange(arr, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q1497 q1497 = new Q1497();
        int[] arr = {-1, 1, -2, 2, -3, 3, -4, 4};
        int k = 3;
        boolean expectResult = true;
        boolean actualResult = q1497.canArrange(arr, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
