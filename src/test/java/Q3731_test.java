import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3731_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3731 q3731 = new Q3731();
        int[] nums = {1, 4, 2, 5};
        List<Integer> expectResult = Arrays.asList(3);
        List<Integer> actualResult = q3731.findMissingElements(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3731 q3731 = new Q3731();
        int[] nums = {7, 8, 6, 9};
        List<Integer> expectResult = new ArrayList<>();
        List<Integer> actualResult = q3731.findMissingElements(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q3731 q3731 = new Q3731();
        int[] nums = {5, 1};
        List<Integer> expectResult = Arrays.asList(2, 3, 4);
        List<Integer> actualResult = q3731.findMissingElements(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
