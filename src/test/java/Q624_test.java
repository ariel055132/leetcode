import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q624_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q624 q624 = new Q624();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3));
        int expectResult = 4;
        int actualResult = q624.maxDistance(arrays);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q624 q624 = new Q624();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1));
        arrays.add(Arrays.asList(1));
        int expectResult = 0;
        int actualResult = q624.maxDistance(arrays);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
