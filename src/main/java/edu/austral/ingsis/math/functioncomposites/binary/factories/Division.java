package edu.austral.ingsis.math.functioncomposites.binary.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.binary.BinaryOperation;
import edu.austral.ingsis.math.functioncomposites.binary.solvers.DivisionSolver;

public class Division implements BinaryOperationFactory {
  @Override
  public BinaryOperation createDoubleOperation(Function function1, Function function2) {
    return new BinaryOperation(function1, function2, " / ", new DivisionSolver());
  }
}
