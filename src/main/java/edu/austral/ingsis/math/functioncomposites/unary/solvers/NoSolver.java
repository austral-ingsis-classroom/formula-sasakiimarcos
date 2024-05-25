package edu.austral.ingsis.math.functioncomposites.unary.solvers;

import edu.austral.ingsis.math.Function;

public class NoSolver implements UnarySolver {
    @Override
    public double solve(Function function) {
        return function.solve();
    }
}
