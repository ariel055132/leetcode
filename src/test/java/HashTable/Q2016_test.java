package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2016_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2016 q2016 = new Q2016();
        int[] nums = {7, 1, 5, 4};
        int expectResult = 4;
        int actualResult = q2016.maximumDifference(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }   

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2016 q2016 = new Q2016();
        int[] nums = {9, 4, 3, 2};
        int expectResult = -1;
        int actualResult = q2016.maximumDifference(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2016 q2016 = new Q2016();
        int[] nums = {1, 5, 2, 10};
        int expectResult = 9;
        int acutalResult = q2016.maximumDifference(nums);
        Assertions.assertEquals(expectResult, acutalResult);
    }
}
