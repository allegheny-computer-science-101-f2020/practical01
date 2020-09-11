package practicalone;

import java.util.concurrent.atomic.AtomicInteger;


// TODO: Add the correct type of Class-level JavaDoc comment
public class Swap {

  /**
   * Performs the swap of the two provided values.
   *
   * @param first the first value; will receive the second value
   * @param second the second value; will receive the first value
   */
  public static void swap(AtomicInteger first, AtomicInteger second) {
    // TODO: Add the implementation of this method
  }

  // TODO: Add the correct type of comment
  public static void main(String[] args) {
    // TODO: Add comments to explain each section of this code
    AtomicInteger dataFirst = new AtomicInteger(10);
    AtomicInteger dataSecond = new AtomicInteger(20);
    System.out.println("Values before the swap:");
    System.out.println("  First value : " + dataFirst.get());
    System.out.println("  Second value: " + dataSecond.get());
    Swap.swap(dataFirst, dataSecond);
    System.out.println("Values after the swap:");
    System.out.println("  First value : " + dataFirst.get());
    System.out.println("  Second value: " + dataSecond.get());
  }
}
