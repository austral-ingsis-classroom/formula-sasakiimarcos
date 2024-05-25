package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.binary.BinaryOperation;
import edu.austral.ingsis.math.functioncomposites.unary.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functionleafs.Variable;

import java.util.Map;

public class SetVariablesVisitor implements Visitor{
    private final Map<String, Double> variables;

    public SetVariablesVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }
    @Override
    public void visit(Numeral numeral) {
        return;
    }

    @Override
    public void visit(Variable variable) {
        if (variables.containsKey(variable.getSymbol())) {
            variable.setValue(variables.get(variable.getSymbol()));
        }
    }

    @Override
    public void visit(BinaryOperation binaryOperation) {
        binaryOperation.getLeftOperand().accept(this);
        binaryOperation.getRightOperand().accept(this);
    }

    @Override
    public void visit(SingleOperation singleOperation) {
        singleOperation.getOperand().accept(this);
    }
}
