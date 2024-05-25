package edu.austral.ingsis.math.functioncomposites.unary.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.unary.SingleOperation;

public interface UnaryOperationFactory {
  SingleOperation createSingleOperation(Function operand);
}
