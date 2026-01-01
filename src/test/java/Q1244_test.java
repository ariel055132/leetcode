import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1244_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1244 q1244 = new Q1244();
        q1244.addScore(1, 73);
        q1244.addScore(2, 56);
        q1244.addScore(3, 39);
        q1244.addScore(4, 51);
        q1244.addScore(5, 4);
        int top = 1;
        int expectResult = 73;
        int actualResult = q1244.top(top);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1244 q1244 = new Q1244();
        q1244.addScore(1, 73);
        q1244.addScore(2, 56);
        q1244.addScore(3, 39);
        q1244.addScore(4, 51);
        q1244.addScore(5, 4);
        q1244.reset(1);
        q1244.reset(2);
        q1244.addScore(2, 51);
        int top = 3;
        int expectResult = 141;
        int actualResult = q1244.top(top);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
