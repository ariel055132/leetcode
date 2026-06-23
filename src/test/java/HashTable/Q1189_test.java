package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1189_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1189 q1189 = new Q1189();
        String text = "nlaebolko";
        int expectResult = 1;
        int actualResult = q1189.maxNumberOfBalloons(text);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1189 q1189 = new Q1189();
        String text = "loonbalxballpoon";
        int expectResult = 2;
        int actualResult = q1189.maxNumberOfBalloons(text);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1189 q1189 = new Q1189();
        String text = "leetcode";
        int expectResult = 0;
        int actualResult = q1189.maxNumberOfBalloons(text);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
