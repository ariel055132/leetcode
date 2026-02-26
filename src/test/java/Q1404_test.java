import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1404_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1404 q1404 = new Q1404();
        String s = "1101";
        int expectResult = 6;
        int actualResult = q1404.numSteps(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1404 q1404 = new Q1404();
        String s = "10";
        int expectResult = 1;
        int actualResult = q1404.numSteps(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q1404 q1404 = new Q1404();
        String s = "1";
        int expectResult = 0;
        int actualResult = q1404.numSteps(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q1404 q1404 = new Q1404();
        String s = "1111011110000011100000110001011011110010111001010111110001";
        int actualResult = q1404.numSteps(s);
        System.out.println(actualResult);
    }
}
