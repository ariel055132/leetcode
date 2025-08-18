import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1_FollowUp_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q1_FollowUp followUp = new Q1_FollowUp();
        int[] nums = {0, 1, 2, 3};
        int target = 3;
        ArrayList<ArrayList<Integer>> expectResult = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 3)),
                new ArrayList<>(List.of(1, 2))
        ));
        ArrayList<ArrayList<Integer>> actualResult = followUp.twoIntegerSumTarget(nums, target);

        // Sort both lists of pairs for comparison
        expectResult.forEach(Collections::sort);
        actualResult.forEach(Collections::sort);
        Collections.sort(expectResult, (a, b) -> a.get(0) - b.get(0));
        Collections.sort(actualResult, (a, b) -> a.get(0) - b.get(0));
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q1_FollowUp followUp = new Q1_FollowUp();
        int[] nums = {0, 0, 2, 2};
        int target = 2;
        ArrayList<ArrayList<Integer>> expectResult = new ArrayList<>(List.of(
           new ArrayList<>(List.of(0, 3)),
           new ArrayList<>(List.of(1, 2))
        ));
        ArrayList<ArrayList<Integer>> actualResult = followUp.twoIntegerSumTarget(nums, target);
        // Sort both lists of pairs for comparison
        expectResult.forEach(Collections::sort);
        actualResult.forEach(Collections::sort);
        Collections.sort(expectResult, (a, b) -> a.get(0) - b.get(0));
        Collections.sort(actualResult, (a, b) -> a.get(0) - b.get(0));
        Assertions.assertEquals(expectResult, actualResult);
    }
}
