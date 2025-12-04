import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2211_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2211 q2211 = new Q2211();
        String directions = "RLRSLL";
        int expectResult = 5;
        int actualResult = q2211.countCollisions(directions);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2211 q2211 = new Q2211();
        String directions = "LLRR";
        int expectResult = 0;
        int actualResult = q2211.countCollisions(directions);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2211 q2211 = new Q2211();
        String directions = "RSLLRSSL";
        int expectResult = 5;
        int actualResult = q2211.countCollisions(directions);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q2211 q2211 = new Q2211();
        String directions = "RRRRLL";
        int expectResult = 6;
        int actualResult = q2211.countCollisions(directions);
        Assertions.assertEquals(expectResult,actualResult);
    }
}
