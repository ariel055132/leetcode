import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3516_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q3516 q3516 = new Q3516();
        int person1Pos = 2;
        int person2Pos = 7;
        int person3Pos = 4;
        int expectResult = 1;
        int actualResult = q3516.findClosest(person1Pos, person2Pos, person3Pos);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q3516 q3516 = new Q3516();
        int person1Pos = 2;
        int person2Pos = 5;
        int person3Pos = 6;
        int expectResult = 2;
        int actualResult = q3516.findClosest(person1Pos, person2Pos, person3Pos);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q3516 q3516 = new Q3516();
        int person1Pos = 1;
        int person2Pos = 5;
        int person3Pos = 3;
        int expectResult = 0;
        int actualResult = q3516.findClosest(person1Pos, person2Pos, person3Pos);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
