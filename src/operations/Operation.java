package operations;

import java.util.List;

public interface Operation
{
  String getName();

  String getOperand();

  int compute(List<Integer> values);
}
