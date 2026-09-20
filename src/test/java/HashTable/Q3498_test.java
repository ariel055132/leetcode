package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3498_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q3498 q3498 = new Q3498();
        String s = "abc";
        int expectResult = 148;
        int actualResult = q3498.reverseDegree(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q3498 q3498 = new Q3498();
        String s = "zaza";
        int expectResult = 160;
        int actualResult = q3498.reverseDegree(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
