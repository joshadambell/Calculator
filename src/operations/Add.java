package operations;

import lombok.Getter;

public class Add implements Operation
{
  @Getter
  private final String name = "add";

  @Getter
  private final String operand = "+";

  @Override
  public int compute(int first, int second)
  {
    return first + second;
  }
}
