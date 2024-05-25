package edu.austral.ingsis.math.functionleafs;

import edu.austral.ingsis.math.visitors.Visitor;

public class Numeral implements Value {
  private final double value;

  public Numeral(double value) {
    this.value = value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String getSymbol() {
    return String.format("%.0f", value);
  }

  @Override
  public double solve() {
    return value;
  }
}
