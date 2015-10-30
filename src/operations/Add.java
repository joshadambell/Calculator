package operations;

import java.util.List;

import lombok.Getter;

public class Add implements Operation
{
  @Getter
  private String name;

  @Getter
  private String operand;

  @Override
  public int compute(List<Integer> values)
  {
    int sum = 0;
    for (final Integer v : values)
    {
      sum += v;
    }
    return sum;
  }
}
