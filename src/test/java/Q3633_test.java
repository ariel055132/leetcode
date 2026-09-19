import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3633_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3633 q3633 = new Q3633();
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int expectResult = 9;
        int actualResult = q3633.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3633 q3633 = new Q3633();
        int[] landStartTime = {5};
        int[] landDuration = {3};
        int[] waterStartTime = {1};
        int[] waterDuration = {10};
        int expectResult = 14;
        int actualResult = q3633.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
