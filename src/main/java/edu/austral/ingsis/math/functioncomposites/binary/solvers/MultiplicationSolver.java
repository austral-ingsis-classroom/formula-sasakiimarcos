package edu.austral.ingsis.math.functioncomposites.binary.solvers;

import edu.austral.ingsis.math.Function;

public class MultiplicationSolver implements BinarySolver {
  @Override
  public double solve(Function function1, Function function2) {
    return function1.solve() * function2.solve();
  }
}
