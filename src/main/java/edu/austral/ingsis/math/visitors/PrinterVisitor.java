package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functionleafs.Number;
import edu.austral.ingsis.math.functioncomposites.Operation;
import edu.austral.ingsis.math.functionleafs.Variable;

public class PrinterVisitor implements Visitor{
    private StringBuilder result = new StringBuilder();

    public PrinterVisitor() {
    }

    @Override
    public void visit(Number number) {
        result.append(number.getSymbol());
    }

    @Override
    public void visit(Variable variable) {
        result.append(variable.getSymbol());
    }

    @Override
    public void visit(Operation operation) {
        result.append("(");
        result.append(operation.getSymbol());

        result.append(")");
    }
}
