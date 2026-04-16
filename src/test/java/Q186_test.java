import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q186_test {
    @Test
    @DisplayName("Test Reverse")
    void test1() {
        Q186 q186 = new Q186();
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] expectResult = {'e','u','l','b',' ','s','i',' ','y','k','s',' ','e','h','t'};
        q186.reverse(s, 0, s.length - 1);
        Assertions.assertArrayEquals(expectResult, s);
    }   

    @Test
    @DisplayName("Test 1")
    void test2() {
        Q186 q186 = new Q186();
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] expectResult = {'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
        q186.reverseWords(s);
        Assertions.assertArrayEquals(expectResult, s);
    }
}
