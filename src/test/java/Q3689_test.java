import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3689_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3689 q3689 = new Q3689();
        int[] nums = {1, 3, 2};
        int k = 2;
        long expectResult = 4;
        long actualResult = q3689.maxTotalValue(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3689 q3689 = new Q3689();
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        long expectResult = 12;
        long actualResult = q3689.maxTotalValue(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void hiddenTest() {
        Q3689 q3689 = new Q3689();
        int[] nums = {701025805,484014287,486484825,479659005,127752519,497392660,905035207,885813233,36336196,83624455,562558760,504283643,414557507,340461196,75269772,787067318,310705037,994901461,509673195,908722607,69228965,239220571,719440526,986897320};
        int k = 78;
        long expectResult = 74768090670L;
        long actualResult = q3689.maxTotalValue(nums, k);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
