package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.dual.DoubleOperation;
import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Number;
import edu.austral.ingsis.math.functionleafs.Variable;

import java.util.ArrayList;
import java.util.List;

public class GetVariablesVisitor implements Visitor{

    private List<String> variables;

    public GetVariablesVisitor() {
        this.variables = new ArrayList<>();
    }

    @Override
    public void visit(Number number) {
        return;
    }

    @Override
    public void visit(Variable variable) {
        variables.add(variable.getSymbol());
    }

    @Override
    public void visit(DoubleOperation doubleOperation) {
        doubleOperation.getLeftOperand().accept(this);
        doubleOperation.getRightOperand().accept(this);
    }

    @Override
    public void visit(SingleOperation singleOperation) {
        singleOperation.getOperand().accept(this);
    }

    public List<String> getVariables() {
        return variables;
    }
}
