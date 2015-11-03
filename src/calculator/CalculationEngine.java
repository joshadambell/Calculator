package calculator;

import java.util.Optional;
import java.util.Set;

import operations.CustomOperation;
import operations.Operation;

public class CalculationEngine
{
  private final Set<Operation> operations;

  public CalculationEngine(final Set<Operation> ops)
  {
    this.operations = ops;
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

  public void createCustomOperation(String name, String operand)
  {
    this.operations.add(new CustomOperation(name, operand));
  }

  private Optional<Operation> findOperation(String operation)
  {
    return this.operations.stream()
        .filter((op) -> op.getOperation().equals(operation) || op.getOperand().equals(operation))
        .findFirst();
  }
}
