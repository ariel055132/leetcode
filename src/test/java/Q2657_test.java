import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2657_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2657 q2657 = new Q2657();
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        int[] expectResult = {0, 2, 3, 4};
        int[] actualResult = q2657.findThePrefixCommonArray(A, B);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2657 q2657 = new Q2657();
        int[] A = {2, 3, 1};
        int[] B = {3, 1, 2};
        int[] expectResult = {0, 1, 3};
        int[] actualResult = q2657.findThePrefixCommonArray(A, B);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
