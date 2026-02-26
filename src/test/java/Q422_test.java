import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q422_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q422 q422 = new Q422();
        List<String> list = Arrays.asList("abcd", "bnrt", "crm", "dt");
        boolean expectResult = true;
        boolean actualResult = q422.validWordSquare(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q422 q422 = new Q422();
        List<String> list = Arrays.asList("abcd","bnrt","crmy","dtye");
        boolean expectResult = true;
        boolean actualResult = q422.validWordSquare(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q422 q422 = new Q422();
        /**
         * b a l l 
         * a r e a
         * r e a d
         * l a d y
         * 
         * read != lead -> reþ
         */
        List<String> list = Arrays.asList("ball","area","read","lady");
        boolean expectResult = false;
        boolean actualResult = q422.validWordSquare(list); 
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {

    }
}
