package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q734_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q734 q734 = new Q734();
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = new ArrayList<>();
        List<String> pair1 = Arrays.asList("great", "fine");
        List<String> pair2 = Arrays.asList("drama", "acting");
        List<String> pair3 = Arrays.asList("skills","talent");
        similarPairs.add(pair1);
        similarPairs.add(pair2);
        similarPairs.add(pair3);
        boolean expectResult = true;
        boolean actualResult = q734.areSentencesSimilar(sentence1, sentence2, similarPairs);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q734 q734 = new Q734();
        String[] sentence1 = {"great"};
        String[] sentence2 = {"great"};
        List<List<String>> similarPairs = new ArrayList<>();
        boolean expectResult = true;
        boolean actualResult = q734.areSentencesSimilar(sentence1, sentence2, similarPairs);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q734 q734 = new Q734();
        String[] sentence1 = {"great"};
        String[] sentence2 = {"doubleplus", "good"};
        List<List<String>> similarPairs = new ArrayList<>();
        List<String> pair1 = Arrays.asList("great", "doubleplus");
        similarPairs.add(pair1);
        boolean expectResult = false;
        boolean actualResult = q734.areSentencesSimilar(sentence1, sentence2, similarPairs);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
