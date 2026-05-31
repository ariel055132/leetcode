import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1228_test {
    /**
     * Dry run 
     * Given array was [5, 7, 11, 13]
     * Full Sequence was [5, 7, 9, 11, 13]
     * Missing value is 9
     * difference = (13 - 5) / 4 = 2
     * 
     * index val expect before
     * 0     5    5
     * 1     7    7
     * 2     11   9
     * there return 9
     */
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1228 q1228 = new Q1228();
        int[] arr = {5, 7, 11, 13};
        int expectResult = 9;
        int actualResult = q1228.missingNumber(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1228 q1228 = new Q1228();
        int[] arr = {15, 13, 12};
        int expectResult = 14;
        int actualResult = q1228.missingNumber(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
