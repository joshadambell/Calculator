package tests;

import org.junit.Test;

import calculator.Main;

public class MainIT
{
  @Test
  public void mainIT()
  {
    final Main main = new Main();
    final String[] args = { "mul", "4", "5" };
    main.main(args);

    final String[] args2 = { "mu", "4", "5" };
    main.main(args2);

    final String[] args3 = { "4", "5", "mul" };
    main.main(args3);
  }
}
