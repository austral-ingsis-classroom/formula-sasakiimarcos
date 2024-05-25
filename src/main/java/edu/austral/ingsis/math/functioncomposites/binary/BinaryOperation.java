package edu.austral.ingsis.math.functioncomposites.binary;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.binary.solvers.BinarySolver;
import edu.austral.ingsis.math.visitors.Visitor;

public class BinaryOperation implements Function {
  private final Function leftOperand;
  private final Function rightOperand;
  private final String symbol;
  private final BinarySolver solver;

  public BinaryOperation(
      Function leftOperand, Function rightOperand, String symbol, BinarySolver solver) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.symbol = symbol;
    this.solver = solver;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String getMiddleSymbol() {
    return symbol;
  }

  public Function getLeftOperand() {
    return leftOperand;
  }

  public Function getRightOperand() {
    return rightOperand;
  }

  @Override
  public double solve() {
    return solver.solve(leftOperand, rightOperand);
  }
}
