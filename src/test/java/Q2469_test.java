import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2469_test {
  @Test
  @DisplayName("Test 1")
  void test1() {
    Q2469 q2469 = new Q2469();
    double celsius = 36.5;
    double[] expectResult = { 309.65, 97.7 };
    double[] actualResult = q2469.convertTemperature(celsius);
    Assertions.assertArrayEquals(expectResult, actualResult);
  }
}
