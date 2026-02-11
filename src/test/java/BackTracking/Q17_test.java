package BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q17_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q17_Back q17 = new Q17_Back();
        String digits = "23";
        List<String> expectResult = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actualResult = q17.letterCombinations(digits);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
