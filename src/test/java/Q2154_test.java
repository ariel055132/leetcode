import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2154_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2154 q2154 = new Q2154();
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        int expectResult = 24;
        int actualResult = q2154.findFinalValue(nums, original);
        Assertions.assertEquals(expectResult, actualResult);
    }


}
