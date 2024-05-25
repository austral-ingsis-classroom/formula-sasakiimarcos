package edu.austral.ingsis.math.functioncomposites.unary.solvers;

import edu.austral.ingsis.math.Function;

public class RootSolver implements UnarySolver {
  @Override
  public double solve(Function function) {
    return Math.sqrt(function.solve());
  }
}
