import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q3_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q3 q3 = new Q3();
        String s = "abcabcbb";
        int expectResult = 3;
        int actualResult = q3.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void example2() {
        Q3 q3 = new Q3();
        String s = "bbbbb";
        int expectResult = 1;
        int actualResult = q3.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void example3() {
        Q3 q3 = new Q3();
        String s = "pwwkew";
        int expectResult = 3;
        int actualResult = q3.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
