package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3514_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q3514_BruteForce q3514 = new Q3514_BruteForce();
        int[] nums = {1, 3};
        int expectResult = 2;
        int actualResult = q3514.uniqueXorTriplets(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q3514_BruteForce q3514 = new Q3514_BruteForce();
        int[] nums = {6, 7, 8, 9};
        int expectResult = 4;
        int actualResult = q3514.uniqueXorTriplets(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
