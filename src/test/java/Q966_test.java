import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q966_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q966 q966 = new Q966();
        String[] wordlist = {"kite"};
        String[] queries = {"kite"};
        String[] expectResult = {"kite"};
        String[] actualResult = q966.spellchecker(wordlist, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q966 q966 = new Q966();
        String[] wordlist = {"KiTe", "kite"};
        String[] queries = {"kite", "Kite"};
        String[] expectResult = {"kite", "KiTe"};
        String[] actualResult = q966.spellchecker(wordlist, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q966 q966 = new Q966();
        String[] wordlist = {"KiTe", "kite"};
        String[] queries = {"kite", "Kite", "kkkk"};
        String[] expectResult = {"kite", "KiTe", ""};
        String[] actualResult = q966.spellchecker(wordlist, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q966 q966 = new Q966();
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String[] expectResult = {"kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"};
        String[] actualResult = q966.spellchecker(wordlist, queries);
        Assertions.assertArrayEquals(expectResult, actualResult);
    }
}
