package Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1429_test {
    @Test
    @DisplayName("LeetCode Example 1")
    void leetcodeExample1() {
        Q1429 firstUnique = new Q1429(new int[] {2, 3, 5});

        Assertions.assertEquals(2, firstUnique.showFirstUnique());
        firstUnique.add(5);
        Assertions.assertEquals(2, firstUnique.showFirstUnique());
        firstUnique.add(2);
        Assertions.assertEquals(3, firstUnique.showFirstUnique());
        firstUnique.add(3);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
    }

    @Test
    @DisplayName("LeetCode Example 2")
    void leetcodeExample2() {
        Q1429 firstUnique = new Q1429(new int[] {7, 7, 7, 7, 7, 7});

        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(7);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(3);
        Assertions.assertEquals(3, firstUnique.showFirstUnique());
        firstUnique.add(3);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(7);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(17);
        Assertions.assertEquals(17, firstUnique.showFirstUnique());
    }

    @Test
    @DisplayName("LeetCode Example 3")
    void leetcodeExample3() {
        Q1429 firstUnique = new Q1429(new int[] {809});

        Assertions.assertEquals(809, firstUnique.showFirstUnique());
        firstUnique.add(809);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
        firstUnique.add(10);
        Assertions.assertEquals(10, firstUnique.showFirstUnique());
        firstUnique.add(809);
        Assertions.assertEquals(10, firstUnique.showFirstUnique());
        firstUnique.add(10);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
    }

    @Test
    @DisplayName("Unique moves forward when current unique becomes duplicate")
    void uniqueMovesForward() {
        Q1429 firstUnique = new Q1429(new int[] {1, 2, 1, 3, 2, 4});

        Assertions.assertEquals(3, firstUnique.showFirstUnique());
        firstUnique.add(3);
        Assertions.assertEquals(4, firstUnique.showFirstUnique());
        firstUnique.add(4);
        Assertions.assertEquals(-1, firstUnique.showFirstUnique());
    }
}
