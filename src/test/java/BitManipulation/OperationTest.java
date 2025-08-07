package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {
    private Operation operation;

    @BeforeEach
    void init() {
        operation = new Operation();
    }

    @Test
    @DisplayName("Test AND operation")
    void testAnd() {
        int result = operation.and();
        Assertions.assertEquals(result, 34);
    }

    @Test
    @DisplayName("Test Right Shift Operation")
    void testRightShift() {
        int result = operation.rightShift();
        Assertions.assertEquals(result, 6);
    }

    @Test
    @DisplayName("Test Left Shift Operation")
    void testLeftShift() {
        int result = operation.leftShift();
        System.out.println(result);
    }

    @Test
    @DisplayName("Test Odd / Even number with Odd Number")
    void testOddEvenNumber_OddNumber() {
        int num = 13;
        String actualResult = operation.checkingOddEven(num);
        String expectedResult = "Odd";
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Test Odd / Even number with Even number")
    void testOddEvenNumber_EvenNumber() {
        int num = 14;
        String actualResult = operation.checkingOddEven(num);
        String expectedResult = "Even";
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Test Decimal number convert to Binary")
    void testDecimalToBinary() {
        String actualResult = operation.decimalToBinary(13);
        String expectedResult = "1101";
        Assertions.assertEquals(actualResult, expectedResult);
    }
}
