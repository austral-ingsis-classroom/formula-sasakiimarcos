package edu.austral.ingsis.math.functioncomposites.single.solvers;

import edu.austral.ingsis.math.Function;

public class AbsoluteSolver implements SingleSolver{
    @Override
    public double solve(Function function) {
        return Math.abs(function.solve());
    }
}
