package tests;

import static org.junit.Assert.*;
import operations.Add;
import operations.Div;
import operations.Mul;
import operations.Sub;

import org.junit.Test;

public class OperationsTest
{
  @Test
  public void addTest()
  {
    assertEquals(5, new Add().compute(3, 2));
  }

  @Test
  public void subTest()
  {
    assertEquals(1, new Sub().compute(3, 2));
  }

  @Test
  public void mulTest()
  {
    assertEquals(6, new Mul().compute(3, 2));
  }

  @Test
  public void divTest()
  {
    assertEquals(1, new Div().compute(2, 2));
  }
}
