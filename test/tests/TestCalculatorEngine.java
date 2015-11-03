package tests;

import java.util.Optional;

import operations.Add;
import operations.Mul;
import operations.Sub;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import calculator.CalculationEngine;

import com.google.common.collect.Sets;

public class TestCalculatorEngine
{
  static CalculationEngine engine;

  @BeforeClass
  public static void before()
  {
    engine = new CalculationEngine(Sets.newHashSet(new Add(), new Sub(), new Mul()));
  }

  @Test
  public void testFindAndCompute()
  {
    assert (engine.compute("mul", 5, 5).equals(25));
  }

  @Test
  public void invalid()
  {
    final Optional<Integer> value = engine.compute("mu", 5, 5);

    if (value.isPresent())
    {
      Assert.fail();
    }
  }
}
