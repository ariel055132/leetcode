package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q948_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q948 q948 = new Q948();
        int[] tokens = {100};
        int power = 50;
        int expectResult = 0;
        int actualResult = q948.bagOfTokensScore(tokens, power);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q948 q948 = new Q948();
        int[] tokens = {200, 100};
        int power = 150;
        int expectResult = 1;
        int actualResult = q948.bagOfTokensScore(tokens, power);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q948 q948 = new Q948();
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int expectResult = 2;
        int actualResult = q948.bagOfTokensScore(tokens, power);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q948 q948 = new Q948();
        int[] tokens = {26};
        int power = 51;
        int expectResult = 1;
        int actualResult = q948.bagOfTokensScore(tokens, power);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
