package edu.austral.ingsis.math.functioncomposites.single.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functioncomposites.single.solvers.RootSolver;

public class Root implements SingleOperationFactory{
    @Override
    public SingleOperation createSingleOperation(Function operand) {
        return new SingleOperation(operand, "√", "", new RootSolver());
    }
}
