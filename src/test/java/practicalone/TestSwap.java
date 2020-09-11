package practicalone;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import practicalone.Swap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A JUnit test suite for Swap.
 *
 * @author Add Your Name Here
 */

public class TestSwap {

  // TODO: Add at least two more test cases to assess the correctness of the swap

  @Test
  public void testValuesEqualNoSwapEvident() {
    // rationale to explain the purpose of this test
    AtomicInteger first = new AtomicInteger(10);
    AtomicInteger second = new AtomicInteger(10);
    Swap.swap(first, second);
    assertEquals(first.get(), 10);
    assertEquals(second.get(), 10);
  }

}
