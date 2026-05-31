package Trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3043_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3043 q3043 = new Q3043();
        int[] arr1 = {1, 100, 10};
        int[] arr2 = {1000};
        int expectResult = 3;
        int actualResult = q3043.longestCommonPrefix(arr1, arr2);
        Assertions.assertEquals(expectResult, actualResult);
    }  

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3043 q3043 = new Q3043();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 4, 4};
        int expectResult = 0;
        int actualResult = q3043.longestCommonPrefix(arr1, arr2);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
