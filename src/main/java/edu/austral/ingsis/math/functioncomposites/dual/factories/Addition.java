package edu.austral.ingsis.math.functioncomposites.dual.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.dual.DoubleOperation;
import edu.austral.ingsis.math.functioncomposites.dual.solvers.AdditionSolver;

public class Addition implements DoubleOperationFactory{
    @Override
    public DoubleOperation createDoubleOperation(Function function1, Function function2) {
        return new DoubleOperation(function1, function2, " + ", new AdditionSolver());
    }
}
