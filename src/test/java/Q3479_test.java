import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3479_test {
    @Test
    @DisplayName("Example 1")
    void testExample1() {
        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};
        Q3479 q3479 = new Q3479();
        int actualResult = q3479.numOfUnplacedFruits(fruits, baskets);
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void testExample2() {
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        Q3479 q3479 = new Q3479();
        int actualResult = q3479.numOfUnplacedFruits(fruits, baskets);
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
