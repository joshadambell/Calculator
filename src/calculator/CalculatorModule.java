package calculator;

import javax.inject.Singleton;

import operations.Add;
import operations.Div;
import operations.Mul;
import operations.Sub;

import org.eclipse.jetty.servlet.DefaultServlet;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Sets;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class CalculatorModule extends ServletModule
{
  @Override
  protected void configureServlets()
  {
    // final Multibinder<Operation> operationsMultibind =
    // Multibinder.newSetBinder(this.binder(), Operation.class);
    //
    // operationsMultibind.addBinding().toInstance(new Add());
    // operationsMultibind.addBinding().toInstance(new Sub());
    // operationsMultibind.addBinding().toInstance(new Mul());
    // operationsMultibind.addBinding().toInstance(new Div());

    this.bind(DefaultServlet.class).in(Singleton.class);

    this.serve("/*").with(GuiceContainer.class);
  }

  @Provides
  @Singleton
  public CalculationEngine getCalculatorResource()
  {
    return new CalculationEngine(Sets.newHashSet(new Add(), new Sub(), new Mul(), new Div()));
  }

  @Provides
  @Singleton
  public CalculatorResource getCalculatorResource(final CalculationEngine engine)
  {
    return new CalculatorResource(engine);
  }

  @Provides
  @Singleton
  public ObjectMapper getObjectMapper()
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    return objectMapper;
  }

  @Provides
  @Singleton
  public JacksonJsonProvider getJacksonJsonProvider(ObjectMapper objecMapper)
  {
    return new JacksonJsonProvider(objecMapper);
  }
}
