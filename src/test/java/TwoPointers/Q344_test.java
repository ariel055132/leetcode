package TwoPointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q344_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q344 q344 = new Q344();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        q344.reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }
}
