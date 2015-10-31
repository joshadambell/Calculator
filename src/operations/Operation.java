package operations;


public interface Operation
{
  String getName();

  String getOperand();

  // Could change to double for divide
  int compute(int first, int second);

  default String format()
  {
    return getName() + ": ";
  };
}
