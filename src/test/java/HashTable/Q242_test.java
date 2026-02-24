package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q242_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q242 q242 = new Q242();
        String s = "anagram";
        String t = "nagaram";
        boolean expectResult = true;
        boolean actualResult = q242.isAnagram(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q242 q242 = new Q242();
        String s = "rat";
        String t = "car";
        boolean expectResult = false;
        boolean actualResult = q242.isAnagram(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test")
    void test1_HashTable() {
        Q242_HashTable q242 = new Q242_HashTable();
        String s = "rat";
        String t = "car";
        boolean expectResult = false;
        boolean actualResult = q242.isAnagram(s, t);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
