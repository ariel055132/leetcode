import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3024_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q3024 q3024 = new Q3024();
        int[] nums = {3, 3, 3};
        String expectResult = "equilateral";
        String actualResult = q3024.triangleType(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q3024 q3024 = new Q3024();
        int[] nums = {3, 4, 5};
        String expectResult = "scalene";
        String actualResult = q3024.triangleType(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q3024 q3024 = new Q3024();
        int[] nums = {2, 3, 3};
        String expectResult = "isosceles";
        String actualResult = q3024.triangleType(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
