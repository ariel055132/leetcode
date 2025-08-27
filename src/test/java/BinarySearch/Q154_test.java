package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q154_test {
    @Test
    @DisplayName("Test 1 (No Rotation)")
    void test1() {
        Q154 q154 = new Q154();
        int[] nums = {1, 3, 5};
        int expectResult = 1;
        int actualResult = q154.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q154 q154 = new Q154();
        int[] nums = {2, 2, 2, 0, 1};
        int expectResult = 0;
        int actualResult = q154.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("One element")
    void test3() {
        Q154 q154 = new Q154();
        int[] nums = {2};
        int expectedResult = 2;
        int actualResult = q154.findMin(nums);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Two elements (No Rotation)")
    void test4() {
        Q154 q154 = new Q154();
        int[] nums = {1, 3};
        int expectResult = 1;
        int actualResult = q154.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Two elements (w/ Rotation)")
    void test5() {
        Q154 q154 = new Q154();
        int[] nums = {3, 1};
        int expectResult = 1;
        int actualResult = q154.findMin(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
