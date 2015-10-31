package calculator;

import java.util.Optional;

import operations.Add;
import operations.Div;
import operations.Mul;
import operations.Sub;

public class Main
{
  final static CalculationEngine engine =
      new CalculationEngine(new Add(), new Sub(), new Mul(), new Div());

  // Input format: op 1 2 or 1 2 op
  public static void main(String[] args)
  {
    try
    {
      final String operation = args[0];
      final int first = Integer.parseInt(args[1]);
      final int second = Integer.parseInt(args[2]);

      compute(operation, first, second);
    }
    catch (final NumberFormatException e)
    {
      try
      {
        final int first = Integer.parseInt(args[0]);
        final int second = Integer.parseInt(args[1]);
        final String operation = args[2];

        compute(operation, first, second);
      }
      catch (final NumberFormatException e1)
      {
        System.out.println("Invalid " + args);
      }
    }
  }

  private static void compute(String operation, int first, int second)
  {
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

  private static String format(String operation, Integer value)
  {
    return operation + ": " + value;
  }
}
