package calculator;

import java.util.EnumSet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.Guice;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceFilter;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    final int port = 7000;

    Guice.createInjector(
        Stage.PRODUCTION,
        new CalculatorModule()
        );

    final Server server = new Server(port);

    final ServletContextHandler context =
        new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
    context.addFilter(GuiceFilter.class, "/*", EnumSet.<javax.servlet.DispatcherType> of(
        javax.servlet.DispatcherType.REQUEST, javax.servlet.DispatcherType.ASYNC));

    context.addServlet(DefaultServlet.class, "/*");

    server.start();

    server.join();
  }
}
