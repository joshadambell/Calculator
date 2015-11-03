package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import operations.Operation;

public class CalculationEngine
{
  private final List<Operation> operations;

  public CalculationEngine(Operation... ops)
  {
    this.operations = Arrays.asList(ops);
  }

  public Optional<Integer> compute(String operation, int first, int second)
  {
    final Optional<Operation> foundOperation = this.findOperation(operation);

    if (foundOperation.isPresent())
    {
      return Optional.of(foundOperation.get().compute(first, second));
    }
    return Optional.empty();
  }

  private Optional<Operation> findOperation(String operation)
  {
    return this.operations.stream().filter((op) -> op.getName().equals(operation)).findFirst();
  }
}
