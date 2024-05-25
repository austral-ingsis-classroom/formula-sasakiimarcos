package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.unary.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functioncomposites.binary.BinaryOperation;
import edu.austral.ingsis.math.functionleafs.Variable;

public interface Visitor {
    void visit(Numeral numeral);
    void visit(Variable variable);
    void visit(BinaryOperation binaryOperation);
    void visit(SingleOperation singleOperation);
}
