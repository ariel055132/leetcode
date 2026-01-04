import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q165_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q165 q165 = new Q165();
        String version1 = "1.2";
        String version2 = "1.10";
        int expectResult = -1;
        int actualResult = q165.compareVersion(version1, version2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q165 q165 = new Q165();
        String version1 = "1.01";
        String version2 = "1.001";
        int expectResult = 0;
        int actualResult = q165.compareVersion(version1, version2);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q165 q165 = new Q165();
        String version1 = "1.0";
        String version2 = "1.0.0.0";
        int expectResult = 0;
        int actualResult = q165.compareVersion(version1, version2);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
