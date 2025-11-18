package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2390_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2390 q2390 = new Q2390();
        String s = "leet**cod*e";
        String expectResult = "lecoe";
        String actualResult = q2390.removeStars(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
