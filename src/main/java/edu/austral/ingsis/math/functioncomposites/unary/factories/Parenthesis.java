package edu.austral.ingsis.math.functioncomposites.unary.factories;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.unary.SingleOperation;
import edu.austral.ingsis.math.functioncomposites.unary.solvers.NoSolver;

public class Parenthesis implements UnaryOperationFactory {
    @Override
    public SingleOperation createSingleOperation(Function operand) {
        return new SingleOperation(operand, "(", ")", new NoSolver());
    }
}
