package edu.austral.ingsis.math.functioncomposites.single.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functioncomposites.single.solvers.NoSolver;

public class Parenthesis implements SingleOperationFactory {
    @Override
    public SingleOperation createSingleOperation(Function operand) {
        return new SingleOperation(operand, "(", ")", new NoSolver());
    }
}
