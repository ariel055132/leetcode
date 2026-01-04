import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3606_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q3606 q3606 = new Q3606();
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};
        List<String> expectResult = Arrays.asList("PHARMA5", "SAVE20");
        List<String> actualResult = q3606.validateCoupons(code, businessLine, isActive);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q3606 q3606 = new Q3606();
        String[] code = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, true, true};
        List<String> expectResult = Arrays.asList("ELECTRONICS_50");
        List<String> actualResult = q3606.validateCoupons(code, businessLine, isActive);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3 (All value in isActive is false)")
    void test3() {
        Q3606 q3606 = new Q3606();
        String[] code = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, false, false};
        List<String> expectResult = new ArrayList<>();
        List<String> actualResult = q3606.validateCoupons(code, businessLine, isActive);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
