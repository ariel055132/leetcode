import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q954_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q954 q954 = new Q954();
        int[] arr = {3, 1, 3, 6};
        boolean expectResult = false;
        boolean actualResult = q954.canReorderDoubled(arr);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
