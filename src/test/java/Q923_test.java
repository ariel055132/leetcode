import TwoPointers.Q923;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q923_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q923 q923 = new Q923();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        int expectResult = 20;
        int actualResult = q923.threeSumMulti(arr, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
