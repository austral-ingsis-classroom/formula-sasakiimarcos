package edu.austral.ingsis.math.functioncomposites.dual.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.dual.DoubleOperation;

public interface DoubleOperationFactory {
    DoubleOperation createDoubleOperation(Function function1, Function function2);
}
