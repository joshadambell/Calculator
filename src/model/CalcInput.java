package model;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalcInput
{
  private final String operand;
  private final Integer second;
  private final Integer first;
  private final String name;
  private final String operation;

  public CalcInput(@JsonProperty("name") String name, @JsonProperty("first") Integer first,
      @JsonProperty("second") Integer second, @JsonProperty("operand") String operand,
      @JsonProperty("operation") String operation)
  {
    this.name = name;
    this.first = first;
    this.second = second;
    this.operand = operand;
    this.operation = operation;
  }
}
