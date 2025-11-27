import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1128_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1128 q1128 = new Q1128();
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int expectResult = 1;
        int actualResult = q1128.numEquivDominoPairs(dominoes);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1128 q1128 = new Q1128();
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int expectResult = 3;
        int actualResult = q1128.numEquivDominoPairs(dominoes);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
