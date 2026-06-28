import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.apple.laf.resources.aqua_zh_CN;

public class Q1180_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1180 q1180 = new Q1180();
        String s = "aaaba";
        int expectResult = 8;
        int actualResult = q1180.countLetters2(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1180 q1180 = new Q1180();
        String s = "aaaaaaaaaa";
        int expectResult = 55;
        int actualResult = q1180.countLetters2(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
