import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q288_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String[] dictionary = {"deer", "door", "cake", "card"};
        Q288 q288 = new Q288(dictionary);
        Assertions.assertEquals(false, q288.isUnique("dear"));
        Assertions.assertEquals(true, q288.isUnique("cart"));
        Assertions.assertEquals(false, q288.isUnique("cane"));
        Assertions.assertEquals(true, q288.isUnique("make"));
        Assertions.assertEquals(true, q288.isUnique("cake"));
    }

}
