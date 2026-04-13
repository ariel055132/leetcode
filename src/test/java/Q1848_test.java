import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1848_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1848 q1848 = new Q1848();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;
        int expectResult = 1;
        int actualResult = q1848.getMinDistance(nums, target, start);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1848 q1848 = new Q1848();
        int[] nums = {1};
        int target = 1;
        int start = 0;
        int expectResult = 0;
        int actualResult = q1848.getMinDistance(nums, target, start);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1848 q1848 = new Q1848();
        int[] nums = {1,1,1,1,1,1,1,1,1,1};
        int target = 1;
        int start = 0;
        int expectResult = 0;
        int actualResult = q1848.getMinDistance(nums, target, start);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
