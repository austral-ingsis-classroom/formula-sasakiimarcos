package edu.austral.ingsis.math.functionleafs;

import edu.austral.ingsis.math.visitors.Visitor;
import java.util.NoSuchElementException;

public class Variable implements Value {
  private final String name;
  private Double value;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String getSymbol() {
    if (value == null) {
      return name;
    }
    return String.format("%.0f", value);
  }

  @Override
  public double solve() {
    if (value == null) {
      throw new NoSuchElementException("Variable " + name + " has no value");
    }
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
