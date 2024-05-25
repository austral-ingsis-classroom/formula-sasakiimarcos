package edu.austral.ingsis.math.functioncomposites.dual.solvers;

import edu.austral.ingsis.math.Function;

public class SubtractionSolver implements DoubleSolver{
    @Override
    public double solve(Function function1, Function function2) {
        return function1.solve() - function2.solve();
    }
}
