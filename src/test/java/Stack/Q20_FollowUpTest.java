package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q20_FollowUpTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String s = "()";
        Q20_FollowUp q20FollowUp = new Q20_FollowUp();
        String expectResult = "()";
        String actualResult = q20FollowUp.convertToValidBracketString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String s = "[(";
        Q20_FollowUp q20FollowUp = new Q20_FollowUp();
        String expectResult = "[()]";
        String actualResult = q20FollowUp.convertToValidBracketString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String s = ")";
        Q20_FollowUp q20FollowUp = new Q20_FollowUp();
        String expectResult = "()";
        String actualResult = q20FollowUp.convertToValidBracketString(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
