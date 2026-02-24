import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q762_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q762 q762 = new Q762();
        int left = 6;
        int right = 10;
        int expectResult = 4;
        int actualResult = q762.countPrimeSetBits(left, right);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q762 q762 = new Q762();
        int left = 10;
        int right = 15;
        int expectResult = 5;
        int actualResult = q762.countPrimeSetBits(left, right);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Check Primes 1")
    void checkPrimes1() {
        Q762 q762 = new Q762();
        int number = 1;
        boolean expectResult = false;
        boolean actualResult = q762.checkPrimes(number);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Check Primes 2")
    void checkPrimes2() {
        Q762 q762 = new Q762();
        int number = 4;
        boolean expectResult = false;
        boolean actualResult = q762.checkPrimes(number);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Check Primes 3")
    void checkPrimes3() {
        Q762 q762 = new Q762();
        int number = 3;
        boolean expectResult = true;
        boolean actualResult = q762.checkPrimes(number);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
