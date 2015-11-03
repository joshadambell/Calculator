import java.util.ArrayList;
import java.util.List;

import operations.Add;
import operations.Div;
import operations.Mul;
import operations.Operation;
import operations.Sub;

public class Main
{
  private static List<Operation> operations = new ArrayList<Operation>();

  public static void main(String[] args)
  {
    init();
    try
    {
      final int first = Integer.parseInt(args[0]);
      final int second = Integer.parseInt(args[1]);

      operations.forEach((op) -> System.out.println(op.format() + op.compute(first, second)));
    }
    catch (final NumberFormatException e)
    {
      System.out.println("All inputs are not numbers");
    }
  }

  private static void init()
  {
    operations.add(new Add());
    operations.add(new Sub());
    operations.add(new Mul());
    operations.add(new Div());
  }
}
