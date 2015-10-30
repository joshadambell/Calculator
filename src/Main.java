

import java.util.ArrayList;
import java.util.List;

import operations.Add;
import operations.Operation;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      final List<Integer> values = convertArgs(args);
      System.out.println(new Add().compute(values));
    }
    catch (final NumberFormatException e)
    {
      System.out.println("All inputs are not numbers");
    }
  }

  public static List<Integer> convertArgs(String[] args) throws NumberFormatException
  {
    final List<Integer> values = new ArrayList<>();
    for (final String a : args)
    {
      values.add(Integer.parseInt(a));
    }
    return values;
  }
}
