package PrefixSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3756_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q3756 q3756 = new Q3756();
        String s = "10203004";
        int[][] queries = {{0, 7}, {1, 3}, {4, 6}};
        int[] expectResult = {12340, 4, 9};
        int[] actualResult = q3756.sumAndMultiply(s, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 1 Prefix Sum")
    void test1PrefixSum() {
        Q3756PrefixSum q3756 = new Q3756PrefixSum();
        String s = "10203004";
        int[][] queries = {{0, 7}, {1, 3}, {4, 6}};
        int[] expectResult = {12340, 4, 9};
        int[] actualResult = q3756.sumAndMultiply(s, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
