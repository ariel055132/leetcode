import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Q3507_test {
    @Test
    @DisplayName("Test nonDecreasing Function 1")
    void test_nonDecreasingFunction() {
        Q3507 q3507 = new Q3507();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2));
        boolean expectResult = true;
        boolean actualResult = q3507.isNonDecreasing(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test nonDecreasing Function 2")
    void test_nonDecreasingFunction1() {
        Q3507 q3507 = new Q3507();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 1, 2));
        boolean expectResult = false;
        boolean actualResult = q3507.isNonDecreasing(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3507 q3507 = new Q3507();
        int[] nums = {5, 2, 3, 1};
        int expectResult = 2;
        int actualResult = q3507.minimumPairRemoval(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
