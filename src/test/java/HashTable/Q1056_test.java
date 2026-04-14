package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1056_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1056 q1056 = new Q1056();
        int n = 6;
        boolean expectResult = true;
        boolean actualResult = q1056.confusingNumber(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2 (Leading zeros)")
    void test2() {
        Q1056 q1056 = new Q1056();
        int n = 8000;
        boolean expectResult = true;
        boolean actualResult = q1056.confusingNumber(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1056 q1056 = new Q1056();
        int n = 89;
        boolean expectResult = true;
        boolean actualResult = q1056.confusingNumber(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q1056 q1056 = new Q1056();
        int n = 11;
        boolean expectResult = false;
        boolean actualResult = q1056.confusingNumber(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
