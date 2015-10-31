package calculator;

import java.util.Optional;

import operations.Add;
import operations.Div;
import operations.Mul;
import operations.Sub;

public class Main
{
  public static void main(String[] args)
  {
    final CalculationEngine engine =
        new CalculationEngine(new Add(), new Sub(), new Mul(), new Div());

    final String operation = args[0];
    try
    {
      final int first = Integer.parseInt(args[1]);
      final int second = Integer.parseInt(args[2]);

      final Optional<Integer> value = engine.compute(operation, first, second);
      if (value.isPresent())
      {
        System.out.println(format(operation, value.get()));
      }
      else
      {
        System.out.println("Invalid operation");
      }
    }
    catch (final NumberFormatException e)
    {
      System.out.println("All inputs are not numbers");
    }
  }

  private static String format(String operation, Integer value)
  {
    return operation + ": " + value;
  }
}
