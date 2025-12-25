import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3075_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3075 q3075 = new Q3075();
        int[] happiness = {1, 2, 3};
        int k = 2;
        long expectResult = 4;
        long actualResult = q3075.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test")
    void hiddenTest(){
        Q3075 q3075 = new Q3075();
        int[] happiness = {2, 83, 62};
        int k = 3;
        long expectResult = 144;
        long actualResult = q3075.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Test 2")
    void hiddenTest2() {
        Q3075 q3075 = new Q3075();
        int[] happiness = {12, 1, 42};
        int k = 3;
        long expectResult = 53;
        long actualResult = q3075.maximumHappinessSum(happiness, k);
    }
}
