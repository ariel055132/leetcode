import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1716_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q1716 q1716 = new Q1716();
        int n = 4;
        int expectResult = 10;
        int actualResult = q1716.totalMoney(n);
        Assertions.assertEquals(expectResult, actualResult);

    }
}
