package edu.austral.ingsis.math.functioncomposites.single;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.functioncomposites.single.solvers.SingleSolver;
import edu.austral.ingsis.math.visitors.Visitor;

public class SingleOperation implements Function {
    private final Function operand;
    private final String leftSymbol;
    private final String rightSymbol;
    private final SingleSolver singleSolver;

    public SingleOperation(Function operand, String leftSymbol, String rightSymbol, SingleSolver singleSolver) {
        this.operand = operand;
        this.leftSymbol = leftSymbol;
        this.rightSymbol = rightSymbol;
        this.singleSolver = singleSolver;
    }

    public String getLeftSymbol() {
        return leftSymbol;
    }

    public String getRightSymbol() {
        return rightSymbol;
    }

    public Function getOperand() {
        return operand;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double solve() {
        return singleSolver.solve(operand);
    }
}
