package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3583_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3583 q3583 = new Q3583();
        int[] nums = {6, 3, 6};
        int expectResult = 1;
        int actualResult = q3583.specialTriplets(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3583 q3583 = new Q3583();
        int[] nums = {0, 1, 0, 0};
        int expectResult = 1;
        int actualResult = q3583.specialTriplets(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1 with brute force")
    void test1Brute() {
        Q3583 q3583 = new Q3583();
        int[] nums = {0, 1, 0, 0};
        int expectResult = 1;
        int actualResult = q3583.specialTripletsBrute(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
