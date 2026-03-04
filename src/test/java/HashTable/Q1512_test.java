package HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1512_test {
    @Test
    @DisplayName("Test 1 Normal Case (HashMap)")
    void test1() {
        Q1512 q1512 = new Q1512();
        int[] nums = {1, 2, 3, 1, 1, 3};
        int expectResult = 4;
        int actualResult = q1512.numIdenticalPairs(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2 All good Pairs")
    void test2() {
        Q1512 q1512 = new Q1512();
        int[] nums = {1, 1, 1, 1};
        int expectResult = 6;
        int actualResult = q1512.numIdenticalPairs(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
