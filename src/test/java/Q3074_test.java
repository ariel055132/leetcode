
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3074_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3074 q3074 = new Q3074();
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};
        int expectResult = 2;
        int actualResult = q3074.minimumBoxes(apple, capacity);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
