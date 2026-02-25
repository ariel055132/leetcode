import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1356_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1356 q1356 = new Q1356();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] expectResult = {0, 1, 2, 4, 8, 3, 5, 6, 7};
        int[] actualResult = q1356.sortByBits(arr);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1356 q1356 = new Q1356();
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] expectResult = {1,2,4,8,16,32,64,128,256,512,1024};
        int[] actualResult = q1356.sortByBits(arr);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
