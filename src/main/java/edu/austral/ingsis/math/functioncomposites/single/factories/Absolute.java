package edu.austral.ingsis.math.functioncomposites.single.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functioncomposites.single.factories.SingleOperationFactory;
import edu.austral.ingsis.math.functioncomposites.single.solvers.AbsoluteSolver;

public class Absolute implements SingleOperationFactory {
    @Override
    public SingleOperation createSingleOperation(Function operand) {
        return new SingleOperation(operand, "|", "|" , new AbsoluteSolver());
    }
}
