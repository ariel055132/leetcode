package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2105_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2105 q2105 = new Q2105();
        int[] plants = {2, 2, 3, 3};
        int capacityA = 5;
        int capacityB = 5;
        int expectResult = 1;
        int actualResult = q2105.minimumRefill(plants, capacityA, capacityB);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2105 q2105 = new Q2105();
        int[] plants = {2, 2, 3, 3};
        int capacityA = 3;
        int capacityB = 4;
        int expectResult = 2;
        int actualRseult = q2105.minimumRefill(plants, capacityA, capacityB);
        Assertions.assertEquals(expectResult, actualRseult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q2105 q2105 = new Q2105();
        int[] plants = {5};
        int capacityA = 10;
        int capacityB = 8;
        int expectResult = 0;
        int actualResult = q2105.minimumRefill(plants, capacityA, capacityB);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("WA Test Case")
    void test4() {
        Q2105 q2105 = new Q2105();
        int[] plants = {1, 2, 4, 4, 5};
        int capacityA = 6;
        int capacityB = 5;
        int expectResult = 2;
        int actualResult = q2105.minimumRefill(plants, capacityA, capacityB);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("WA Test Case 2")
    void test5() {
        Q2105 q2105 = new Q2105();
        int[] plants = {2, 1, 1};
        int capacityA = 2;
        int capacityB = 2;
        int expectResult = 0;
        int actualResult = q2105.minimumRefill(plants, capacityA, capacityB);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
