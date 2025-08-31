package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q744_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q744 q744 = new Q744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        char expectResult = 'c';
        char actualResult = q744.nextGreatestLetter(letters, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q744 q744 = new Q744();
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        char expectResult = 'f';
        char actualResult = q744.nextGreatestLetter(letters, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q744 q744 = new Q744();
        char[] letters = {'x', 'x', 'y', 'y'};
        char target = 'z';
        char expectResult = 'x';
        char actualResult = q744.nextGreatestLetter(letters, target);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
