package org.segundoteste;
import java.util.Random;

public class IdGenerator {

  private Random random;

  public IdGenerator() {
    random = new Random();
  }

  public int random() {
    int min = 1;
    return random.nextInt(Integer.MAX_VALUE - min + 1) + min;
  }
}