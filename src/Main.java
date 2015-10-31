
import operations.Add;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println(new Add().compute(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
    catch (final NumberFormatException e)
    {
      System.out.println("All inputs are not numbers");
    }
  }
}
