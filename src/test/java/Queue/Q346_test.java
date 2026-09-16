package Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q346_test {
  private static final double DELTA = 1e-5;

  @Test
  @DisplayName("LeetCode Example: size 3, stream 1, 10, 3, 5")
  void leetcodeExample() {
    Q346 ma = new Q346(3);
    Assertions.assertEquals(1.0, ma.next(1), DELTA);
    Assertions.assertEquals(5.5, ma.next(10), DELTA);
    Assertions.assertEquals(14.0 / 3.0, ma.next(3), DELTA);
    Assertions.assertEquals(6.0, ma.next(5), DELTA);
  }

  @Test
  @DisplayName("Window size 1: each next returns the value itself")
  void windowSizeOne() {
    Q346 ma = new Q346(1);
    Assertions.assertEquals(4.0, ma.next(4), DELTA);
    Assertions.assertEquals(7.0, ma.next(7), DELTA);
    Assertions.assertEquals(2.0, ma.next(2), DELTA);
  }

  @Test
  @DisplayName("Window not full yet: average over all elements seen so far")
  void windowNotFull() {
    Q346 ma = new Q346(5);
    Assertions.assertEquals(2.0, ma.next(2), DELTA);
    Assertions.assertEquals(4.0, ma.next(6), DELTA);
    Assertions.assertEquals(5.0, ma.next(7), DELTA);
  }

  @Test
  @DisplayName("Window slides: oldest value drops out of the average")
  void windowSlides() {
    Q346 ma = new Q346(2);
    Assertions.assertEquals(1.0, ma.next(1), DELTA);
    Assertions.assertEquals(5.5, ma.next(10), DELTA);
    Assertions.assertEquals(6.5, ma.next(3), DELTA);
    Assertions.assertEquals(4.0, ma.next(5), DELTA);
  }
}
