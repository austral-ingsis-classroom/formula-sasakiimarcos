package edu.austral.ingsis.math.functioncomposites.unary;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.unary.solvers.UnarySolver;
import edu.austral.ingsis.math.visitors.Visitor;

public class SingleOperation implements Function {
  private final Function operand;
  private final String leftSymbol;
  private final String rightSymbol;
  private final UnarySolver unarySolver;

  public SingleOperation(
      Function operand, String leftSymbol, String rightSymbol, UnarySolver unarySolver) {
    this.operand = operand;
    this.leftSymbol = leftSymbol;
    this.rightSymbol = rightSymbol;
    this.unarySolver = unarySolver;
  }

  public String getLeftSymbol() {
    return leftSymbol;
  }

  public String getRightSymbol() {
    return rightSymbol;
  }

  public Function getOperand() {
    return operand;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public double solve() {
    return unarySolver.solve(operand);
  }
}
