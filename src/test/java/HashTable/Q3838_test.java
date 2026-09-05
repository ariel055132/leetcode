package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3838_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3838 q3838 = new Q3838();
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        String expectResult = "rij";
        String actualResult = q3838.mapWordWeights(words, weights);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q3838 q3838 = new Q3838();
        String[] words = {"a", "b", "c"};
        int[] weights = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        String expectResult = "yyy";
        String actualResult = q3838.mapWordWeights(words, weights);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 3")
    void test3() {
        Q3838 q3838 = new Q3838();
        String[] words = {"abcd"};
        int[] weights = {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        String expectResult = "g";
        String actualResult = q3838.mapWordWeights(words, weights);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
