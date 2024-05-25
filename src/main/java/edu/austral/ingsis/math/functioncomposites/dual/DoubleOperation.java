package edu.austral.ingsis.math.functioncomposites.dual;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.dual.solvers.DoubleSolver;
import edu.austral.ingsis.math.visitors.Visitor;

public class DoubleOperation implements Function {
    private final Function leftOperand;
    private final Function rightOperand;
    private final String symbol;
    private final DoubleSolver solver;

    public DoubleOperation(Function leftOperand, Function rightOperand, String symbol, DoubleSolver solver) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.symbol = symbol;
        this.solver = solver;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getMiddleSymbol() {
        return symbol;
    }

    public Function getLeftOperand() {
        return leftOperand;
    }

    public Function getRightOperand() {
        return rightOperand;
    }

    @Override
    public double solve() {
        return solver.solve(leftOperand, rightOperand);
    }
}
