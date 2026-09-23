package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q525_test {
    @Test 
    @DisplayName("Test 1 (Brute Force)")
    void test1() {
        Q525 q525 = new Q525();
        int[] nums = {0, 1};
        int expectResult = 2;
        int actualResult = q525.findMaxLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2 (Brute Force)")
    void test2() {
        Q525 q525 = new Q525();
        int[] nums = {0, 1, 0};
        int expectResult = 2;
        int actualResult = q525.findMaxLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 3 (Brute Force)")
    void test3() {
        Q525 q525 = new Q525();
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int expectResult = 6;
        int actualResult = q525.findMaxLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 1 (Prefix Sum optimize)")
    void test4() {
        Q525PrefixSum q525 = new Q525PrefixSum();
        int[] nums = {0, 1};
        int expectResult = 2;
        int actualResult = q525.findMaxLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2") 
    void test5() {
        Q525PrefixSum q525 = new Q525PrefixSum();
        int[] nums = {0, 1, 0};
        int expectResult = 2;
        int actualResult = q525.findMaxLength(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
