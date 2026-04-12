import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1980_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1980 q1980 = new Q1980();
        String[] nums = {"01", "10"};
        String expectResult = "00";
        String actualResult = q1980.findDifferentBinaryString(nums);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
