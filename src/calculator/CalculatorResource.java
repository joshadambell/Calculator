package calculator;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lombok.RequiredArgsConstructor;
import model.CalcInput;
import model.CalcResponse;

import com.google.common.collect.Maps;

@Singleton
@Path("/calculate")
@RequiredArgsConstructor
public class CalculatorResource
{
  private final CalculationEngine engine;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, CalcResponse> calculate(List<CalcInput> inputs)
  {
    final Map<String, CalcResponse> results = Maps.newHashMap();
    inputs.forEach((input) ->
    {
      final Optional<Integer> value =
          this.engine.compute(input.getOperand(), input.getFirst(), input.getSecond());

      if (value.isPresent())
      {
        results.put(input.getName(),
            new CalcResponse(value.get()));
      }
        else
        {
          results.put(input.getName(), new CalcResponse());
        }
    });

    return results;
  }

  @Path("{operation}")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(@PathParam("operation") String operation, CalcInput input)
  {
    final Optional<Integer> value =
        this.engine.compute(operation, input.getFirst(), input.getSecond());
    if (value.isPresent())
    {
      return Response.ok(new CalcResponse(value.get())).build();
    }
    throw new WebApplicationException(400);
  }

  @Path("custom")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response addCustomOperation(CalcInput input, @Context UriInfo uriInfo)
      throws URISyntaxException
  {
    final String operation = input.getOperation();
    final String operand = input.getOperand();

    this.engine.createCustomOperation(operation, operand);

    return Response
        .created(new URI(uriInfo.getBaseUri() + "/calculate/" + operation))
        .build();
  }
}
