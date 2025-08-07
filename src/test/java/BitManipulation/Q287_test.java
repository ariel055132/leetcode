package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q287_test {
    @Test
    @DisplayName("Example 1")
    void testExample1() {
        int[] nums = {1, 3, 4, 2, 2};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate(nums);
        int expectResult = 2;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void testExample2() {
        int[] nums = {3, 1, 3, 4, 2};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate(nums);
        int expectResult = 3;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void testExample3() {
        int[] nums = {3, 3, 3, 3, 3};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate(nums);
        int expectResult = 3;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 1")
    void testExample1_1() {
        int[] nums = {1, 3, 4, 2, 2};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate1(nums);
        int expectResult = 2;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void testExample2_1() {
        int[] nums = {3, 1, 3, 4, 2};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate1(nums);
        int expectResult = 3;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void testExample3_1() {
        int[] nums = {3, 3, 3, 3, 3};
        Q287 q287 = new Q287();
        int actualResult = q287.findDuplicate1(nums);
        int expectResult = 3;
        Assertions.assertEquals(expectResult, actualResult);
    }


}
