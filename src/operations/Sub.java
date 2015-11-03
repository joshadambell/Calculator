package operations;

import lombok.Getter;

public class Sub implements Operation
{
  @Getter
  private final String operation = "sub";

  @Getter
  private final String operand = "-";

  @Override
  public int compute(int first, int second)
  {
    return first - second;
  }
}
