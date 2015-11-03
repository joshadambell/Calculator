package operations;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.ws.rs.WebApplicationException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomOperation implements Operation
{
  @Getter
  private final String operation;

  @Getter
  private final String operand;

  @Override
  public int compute(int first, int second)
  {
    final ScriptEngineManager mgr = new ScriptEngineManager();
    final ScriptEngine engine = mgr.getEngineByName("JavaScript");
    try
    {
      return (int) engine.eval(first + this.operand + second);
    }
    catch (final ScriptException e)
    {
      throw new WebApplicationException(400);
    }
  }

}
