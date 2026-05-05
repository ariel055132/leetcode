import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q796_test {
    @Test
    @DisplayName("Test 1")  
    void test1() {
        /*
         * String s: (abcde -> bcdea -> cdeab -> deabc -> eabcd) -> abcde 
         * String goal: cdeab
         */
        Q796 q796 = new Q796();
        String s = "abcde";
        String goal = "cdeab";
        boolean expectResult = true;
        boolean actualResult = q796.rotateString(s, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }  

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q796 q796 = new Q796();
        String s = "abcde";
        String goal = "abced";
        boolean expectResult = false;
        boolean actualResult = q796.rotateString(s, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q796 q796 = new Q796();
        String s = "aa";
        String goal = "a";
        boolean expectResult = false;
        boolean actualResult = q796.rotateString(s, goal);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
