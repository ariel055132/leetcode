import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q944_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q944 q944 = new Q944();
        String[] strs = {"abc", "bce", "cae"};
        int expectResult = 1;
        int actualResult = q944.minDeletionSize(strs);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
