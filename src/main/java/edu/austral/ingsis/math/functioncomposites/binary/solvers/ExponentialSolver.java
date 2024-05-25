package edu.austral.ingsis.math.functioncomposites.binary.solvers;

import edu.austral.ingsis.math.Function;

public class ExponentialSolver implements BinarySolver {
    @Override
    public double solve(Function function1, Function function2) {
        return Math.pow(function1.solve(), function2.solve());
    }
}
