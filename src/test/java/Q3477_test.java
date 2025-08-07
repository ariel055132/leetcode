import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3477_test {
    @Test
    @DisplayName("Example 1")
    void testExample1() {
        Q3477 q3477 = new Q3477();
        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};
        int actualResult = q3477.numOfUnplacedFruits(fruits, baskets);
        int expectedResult = 1;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}
