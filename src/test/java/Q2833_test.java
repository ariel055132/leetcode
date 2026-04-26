import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2833_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2833 q2833 = new Q2833();
        String moves = "L_RL__R";
        int expectResult = 3;
        int actualResult = q2833.furthestDistanceFromOrigin(moves);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2833 q2833 = new Q2833();
        String moves = "_R__LL_";
        int expectResult = 5;
        int actualResult = q2833.furthestDistanceFromOrigin(moves);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2833 q2833 = new Q2833();
        String moves = "_______";
        int expectResult = 7;
        int actualResult = q2833.furthestDistanceFromOrigin(moves);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Case")
    void hiddenCase() {
        Q2833 q2833 = new Q2833();
        String moves = "R_";
        int expectResult = 2;
        int actualResult = q2833.furthestDistanceFromOrigin(moves);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
