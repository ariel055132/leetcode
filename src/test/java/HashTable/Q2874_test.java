package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2874_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2874 q2874 = new Q2874();
        int[] nums = {12, 6, 1, 2, 7};
        long expectResult = 77; // (12 - 1) * 7
        // prefix = {0, }
        long actualResult = q2874.maximumTripletValue(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2874 q2874 = new Q2874();
        int[] nums = {1, 10, 3, 4, 19};
        long expectResult = 133; // (10 - 3) * 19
        long actualResult = q2874.maximumTripletValue(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2874 q2874 = new Q2874();
        int[] nums = {1, 2, 3};
        long expectResult = 0;
        long actualResult = q2874.maximumTripletValue(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
