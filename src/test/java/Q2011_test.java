import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2011_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2011 q2011 = new Q2011();
        String[] operations = {"--X", "X++", "X++"};
        int expectResult = 1;
        int actualResult = q2011.finalValueAfterOperations(operations);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
