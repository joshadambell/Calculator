package operations;

import lombok.Getter;

public class Div implements Operation
{
  @Getter
  private final String operation = "div";

  @Getter
  private final String operand = "/";

  @Override
  public int compute(int first, int second)
  {
    return first / second;
  }

}
