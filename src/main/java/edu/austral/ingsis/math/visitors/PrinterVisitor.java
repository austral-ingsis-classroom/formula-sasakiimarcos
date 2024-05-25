package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functioncomposites.dual.DoubleOperation;
import edu.austral.ingsis.math.functionleafs.Variable;

public class PrinterVisitor implements Visitor{
    private StringBuilder result;

    public PrinterVisitor() {
        result = new StringBuilder();
    }

    @Override
    public void visit(Numeral numeral) {
        result.append(numeral.getSymbol());
    }

    @Override
    public void visit(Variable variable) {
        result.append(variable.getSymbol());
    }

    @Override
    public void visit(DoubleOperation doubleOperation) {
        doubleOperation.getLeftOperand().accept(this);
        result.append(doubleOperation.getMiddleSymbol());
        doubleOperation.getRightOperand().accept(this);
    }

    @Override
    public void visit(SingleOperation singleOperation) {
        result.append(singleOperation.getLeftSymbol());
        singleOperation.getOperand().accept(this);
        result.append(singleOperation.getRightSymbol());
    }

    public String getResult() {
        return result.toString();
    }
}
