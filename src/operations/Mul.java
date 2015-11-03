package operations;

import lombok.Getter;

public class Mul implements Operation
{
  @Getter
  private final String operation = "mul";

  @Getter
  private final String operand = "*";

  @Override
  public int compute(int first, int second)
  {
    return first * second;
  }

}
