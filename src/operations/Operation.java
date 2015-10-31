package operations;


public interface Operation
{
  String getName();

  String getOperand();

  int compute(int first, int second);
}
