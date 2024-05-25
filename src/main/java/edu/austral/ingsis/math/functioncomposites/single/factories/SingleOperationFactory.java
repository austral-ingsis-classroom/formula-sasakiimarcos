package edu.austral.ingsis.math.functioncomposites.single.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functioncomposites.single.solvers.SingleSolver;

public interface SingleOperationFactory {
    SingleOperation createSingleOperation(Function operand);
}
