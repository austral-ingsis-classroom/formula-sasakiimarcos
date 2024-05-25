package edu.austral.ingsis.math.functioncomposites.single.solvers;

import edu.austral.ingsis.math.Function;

public class NoSolver implements SingleSolver{
    @Override
    public double solve(Function function) {
        return function.solve();
    }
}
