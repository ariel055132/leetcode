import static org.junit.jupiter.api.Assumptions.abort;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q412_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q412 q412 = new Q412();
        int n = 3;
        List<String> expectResult = Arrays.asList("1", "2", "Fizz");
        List<String> actualResult = q412.fizzBizz(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q412 q412 = new Q412();
        int n = 5;
        List<String> expectResult = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
        List<String> actualResult = q412.fizzBizz(n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q412 q412 = new Q412();
        int n = 15;
        List<String> expectResult = Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz");
        List<String> actualResult = q412.fizzBizz(n);
        Assertions.assertEquals(expectResult, actualResult);
    }
}