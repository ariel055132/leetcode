package Quests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q7 q7 = new Q7();
        int[] target = {1, 3};
        int n = 3;
        List<String> expectResult = new ArrayList<>(Arrays.asList("Push", "Push", "Pop", "Push"));
        List<String> actualResult = q7.buildArray(target, n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
