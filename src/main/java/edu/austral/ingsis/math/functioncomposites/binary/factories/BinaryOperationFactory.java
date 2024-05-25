package edu.austral.ingsis.math.functioncomposites.binary.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.binary.BinaryOperation;

public interface BinaryOperationFactory {
  BinaryOperation createDoubleOperation(Function function1, Function function2);
}
